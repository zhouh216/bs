package com.fiction.crawler.web.controller;

import com.fiction.crawler.biz.serives.UserService;
import com.fiction.crawler.domain.dto.User;
import com.fiction.crawler.domain.response.CommonResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;


    //参数校验  范围参数校验可看开源项目
    @RequestMapping(value = "login")
    public CommonResponse login(@Validated @RequestBody User user,BindingResult result){
        if(result.hasErrors()){
            return CommonResponse.failure(result.getFieldError().getDefaultMessage());
        }
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

    @RequestMapping(value = "userList")
    public CommonResponse userList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        return userService.findListUsers(pageNum,pageSize);
    }
    //pageHelp分页
    @RequestMapping(value = "userTestList")
    public CommonResponse userTestList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        return userService.userTestList(pageNum,pageSize);
    }

    @RequestMapping(value = "user")
    public CommonResponse user(){
        return userService.user();
    }
}
