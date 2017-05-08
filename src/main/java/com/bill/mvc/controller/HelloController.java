package com.bill.mvc.controller;


import com.bill.mvc.POJO.Message;
import com.bill.mvc.database.bean.enUserEntity;
import com.bill.mvc.mq.consumer.ConsumerService;
import com.bill.mvc.mq.producter.ProducerService;
import com.bill.mvc.service.UserService;


import com.bill.mvc.utils.DateUtil;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


/**
 *  Created by chenking on 2017/5/5.
 */
@RestController
@RequestMapping(value = "/hello",method = RequestMethod.GET)
public class HelloController {
    public static final Logger Log=Logger.getLogger(HelloController.class);

    @Autowired
    private UserService userService;

    //队列
    @Resource(name="demoQueueDestination")
    private Destination demodestination;
    //生产者
    @Resource(name = "producerservice")
    private ProducerService producerService;
    //消费者
    @Resource(name = "consumerservice")
    private ConsumerService consumerService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String printHello(ModelMap model){
        model.addAttribute("msg","spring mvc hello world");
        model.addAttribute("name","yuntao");
        return "hello";
    }

    @RequestMapping ("/say/{name}")
    public @ResponseBody
    Message say(@PathVariable String name){
        Message<enUserEntity> message=new Message();
        message.setName(name);
        message.setDescription("OK");
       message.setObject( userService.findAllUser());
        return message;
    }

    @ResponseBody
    @RequestMapping(value = "/producer" ,method = RequestMethod.POST)
    public Message<String> producer(HttpServletRequest request)throws IllegalStateException, IOException{

        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
        if(multipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            Iterator iter=multiRequest.getFileNames();
            while (iter.hasNext()){
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null){
                    //send to the jms
                    producerService.sendMessage(demodestination,file.getBytes());

                }
            }
        }

        Message<String> message=new Message<String>();
        message.setDescription(DateUtil.DateToStrNowTime());

        return message;
    }
    @RequestMapping(value = "/onSend",method = RequestMethod.POST)
    public String producer(@RequestParam("message") String message)
    {

        producerService.sendMessage(demodestination,message);
        return "index";
    }
    @ResponseBody
    @RequestMapping(value = "/receive" ,method = RequestMethod.GET)
    public Message<String> queue_receive() throws JMSException{
        TextMessage tm=consumerService.receive(demodestination);
        Message<String> message=new Message<String>();

        message.setName(tm.getText().toLowerCase());
        return message;
    }




}
