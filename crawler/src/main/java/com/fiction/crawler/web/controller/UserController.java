package com.fiction.crawler.web.controller;

import com.fiction.crawler.biz.serives.UserService;
import com.fiction.crawler.domain.dto.User;
import com.fiction.crawler.domain.response.CommonResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping(value = "login")
    public CommonResponse login(User user){
        return userService.checkUser(user);
    }

    @RequestMapping(value = "register")
    public CommonResponse register(User user){
        return userService.registerUser(user);
    }

    @RequestMapping(value = "loginOut")
    public CommonResponse loginOut(String key){
        return userService.loginOut(key);
    }

}
