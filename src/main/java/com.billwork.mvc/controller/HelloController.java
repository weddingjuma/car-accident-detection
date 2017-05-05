package com.billwork.mvc.controller;


import com.billwork.mvc.POJO.Message;
import com.billwork.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping ("say/{name}")
    public @ResponseBody Message say(@PathVariable String name){
        Message message=new Message();
        message.setName(name);
        message.setDescription("OK");

        message.setName(userService.getAllUserNames().get(0));
        return message;
    }


}
