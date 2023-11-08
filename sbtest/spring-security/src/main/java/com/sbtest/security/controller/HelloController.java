package com.sbtest.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    AuthenticationManager authenticationManager;

    @RequestMapping("/hello")
    public String hello(){
        //获取用户信息
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //控制台打印用户信息
        System.out.println("getName = "+auth.getName());
        System.out.println("getAuthorities = "+auth.getAuthorities());
        System.out.println("getCredentials = "+auth.getCredentials());
        System.out.println("getDetail = "+auth.getDetails());
        System.out.println("getPrincipal = "+auth.getPrincipal());

        return "hello";
    }
}
