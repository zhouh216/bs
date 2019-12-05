package com.fiction.crawler.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

    //首页
    @RequestMapping("index")
    public String welcome(){
        return "/index.html";
    }

    //爬虫页面
    @RequestMapping("crawler")
    public String crawler(){
        return "/crawler.html";
    }
    //注册页面
    @RequestMapping(value = "register")
    public String registerPage(){
        return "/register.html";
    }
    //登录页面
    @RequestMapping(value = "login")
    public String loginPage(){
        return "/login.html";
    }
}
