package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = {"", "/", "/home"})
    public String index() {
        return "index.html";
    }
    @RequestMapping(value = "/coach")
    public String coach() {
        return "signupforcoach.html";
    }

    @RequestMapping(value="/signInPage")
    public String signPage(){
        return "contact.html";
    }

    @RequestMapping(value="/signUpPage")
    public String signUp(){
        return "signup.html";
    }

    @RequestMapping(value = "/info")
    public String person(HttpServletRequest request,Model model) {
        if(request.getSession().getAttribute("user")==null)
            return "forward:/";
        System.out.println(request.getSession().getAttribute("user").toString());
        model.addAttribute("user",request.getSession().getAttribute("user"));
        return "userInfo.html";
    }

    @RequestMapping(value = "/modefiedInfo")
    public String modifiedInfo(HttpServletRequest request,Model model) {
        if(request.getSession().getAttribute("user")==null)
            return "forward:/";
        System.out.println(request.getSession().getAttribute("user").toString());
        model.addAttribute("user",request.getSession().getAttribute("user"));
        return "modifiedInfo.html";
    }

}