package com.zhenxin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SystemController {
    //首页访问
    @RequestMapping("/index")
    public String index(){
        return "start";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String registe(){
        return "/register";
    }



}
