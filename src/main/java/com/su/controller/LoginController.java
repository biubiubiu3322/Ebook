package com.su.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/success")
    public String success(){
        return "success";
    }

    //注册
    @RequestMapping("/register")
    public String regiest(){
        return "register";
    }

    //管理
    @RequestMapping("/ebook")
    public String ebook(){
        return "ebook";
    }

    //用户管理
    @RequestMapping("/user")
    public String user(){
        return "user";
    }

    //首页
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    //插件小展示
    @RequestMapping("/home")
    public String home(){
        return "home";
    }

}
