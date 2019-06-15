package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.domain.primary.Coach;
import com.example.demo.domain.primary.Course;
import com.example.demo.domain.secondary.ViewLog;
import com.example.demo.repository.secondary.ViewRepository;
import com.example.demo.service.primary.CoachService;
import com.example.demo.service.primary.CourseService;
import com.example.demo.service.primary.CustomerService;
import com.example.demo.service.primary.RedisService;
import com.example.demo.utils.SerializeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Arrays;
import java.util.List;

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

    /*@RequestMapping(value = "/coach_signin", method = RequestMethod.POST)
    @ResponseBody
    public String singIn(@RequestParam String username, @RequestParam String password) {
        Coach c = coachService.login(username, password);
        return JSON.toJSONString(c);
    }*/

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test() throws InterruptedException {
        for(int i=8;i<13;i++) {
            Coach coach = coachService.getById(i);
            Course course = new Course("course-----------"+i+5,123);
            course.setCoach(coach);
            //Coach coach = new Coach("xifoo------"+i, "123456", "18801292026", "BJTU");
        /*Customer customer = new Customer("cifoo","123456","18801292026","BJTU");
        Customer customer1 = new Customer("cifoo1","123456","18801292026","BJTU");

        Course course = new Course("course---1");
        course.getCustomers().add(customer);
        course.getCustomers().add(customer1);

        coach.getCourses().add(course);
        course.setCoach(coach);

        courseService.save(course);
        Thread.sleep(3000);*/
            //coachService.save(coach);
            courseService.save(course);
        }

        return JSON.toJSONString(12342567);
    }

    /*@RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    public String find(){

        Course  course = courseService.findByName("course---1");
        System.out.println(course.toString());
        String s1 = course.getCoach().toString();
        String s2 = course.getCustomers().toString();
        return s1+"</br>"+s2;
    }

    @RequestMapping(value = "list")
    @ResponseBody
    public String listcourse(ModelMap modelMap,
                                   @RequestParam(value = "page", defaultValue = "1") Integer pageNo,
                                   @RequestParam(value = "size", defaultValue = "4") Integer size){
        Page<Course> courses = this.courseService.getCourses(pageNo, size);
        modelMap.addAttribute("courses",courses);
        System.out.println(Arrays.asList(courses));
        return JSON.toJSONString(courses);
    }

    @Autowired
    ViewRepository viewRepository;

    @RequestMapping(value = "view")
    @ResponseBody
    public String viewlog(){

        Date d = new Date();
        ViewLog viewLog = new ViewLog(4,5);

        viewRepository.save(viewLog);
        ViewLog viewLog1 = viewRepository.findById(3).get();
        return JSON.toJSONString(viewLog1);
    }*/



}