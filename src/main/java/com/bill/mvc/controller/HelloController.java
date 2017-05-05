package com.bill.mvc.controller;


import com.bill.mvc.POJO.Message;
import com.bill.mvc.database.bean.enUserEntity;
import com.bill.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  Created by chenking on 2017/5/5.
 */
@RestController
@RequestMapping(value = "/hello",method = RequestMethod.GET)
public class HelloController {

    @Autowired
    private UserService userService;

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


}
