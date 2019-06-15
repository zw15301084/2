package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.example.demo.domain.primary.Coach;
import com.example.demo.service.primary.CoachService;
import com.example.demo.service.primary.CourseService;
import com.example.demo.service.primary.CustomerService;

@Controller
public class CoachController {

    @Autowired
    CoachService coachService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CourseService courseService;

    @RequestMapping(value="/trainerPage")
    public String trainer(Model model){
        List<Coach> coachList= coachService.getRecomCoach();
        model.addAttribute("coachs",coachList);
        return "trainers.html";
    }

    @RequestMapping(value = "/refreshTrainer")
    public String trainers(Model model,
                             @RequestParam(value = "page", defaultValue = "0") Integer pageNo,
                             @RequestParam(value = "size", defaultValue = "9") Integer size)
    {
        Page<Coach> courses = this.coachService.getCourses(pageNo, size);
        model.addAttribute("coachs",courses.getContent());
        return "trainers.html";
    }

    @RequestMapping(value = "/coachSignUp", method = RequestMethod.POST)
    public String signUp(@RequestParam("username") String username, @RequestParam("password") String password,
                         @RequestParam("mobileNum") String mobileNum, @RequestParam("address") String address,
                         @RequestParam("specialties") String specialties,@RequestParam("motto") String motto) {
        Coach c = new Coach();
        c.setAddress(address);
        c.setMobileNum(mobileNum);
        c.setPassword(password);
        c.setUsername(username);
        c.setSpecialties(specialties);
        c.setMotto(motto);
        coachService.signUp(c);
        return "contact.html";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test() throws InterruptedException {
        
        List<Coach> coachList= coachService.getRecomCoach();
        return JSON.toJSONString(coachList);
    }
}