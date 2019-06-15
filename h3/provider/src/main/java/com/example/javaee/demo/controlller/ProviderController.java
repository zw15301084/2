package com.example.javaee.demo.controlller;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.example.javaee.demo.domain.Course;
import com.example.javaee.demo.domain.Customer;
import com.example.javaee.demo.domain.KafkaProducer;
import com.example.javaee.demo.domain.MsgBean;
import com.example.javaee.demo.service.CourseService;
import com.example.javaee.demo.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProviderController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CourseService courseService;

    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "login";
    }

    @RequestMapping(value = "signin", method = RequestMethod.POST)
    public String sign(@RequestParam String username, @RequestParam String password, Model model,HttpSession session) {
        Customer c = customerService.login(username, password);
        if (null == c)
            return "forward:/signInerror";
        model.addAttribute("user", c);
        model.addAttribute("courses", courseService.getAll());
        session.setAttribute("user", c);  
        return "home";
    }

    @RequestMapping(value = "reset_psd",method = RequestMethod.POST)
    public String reset_psd(@RequestParam String username,@RequestParam String password){
        customerService.setpsd(username,password);
        return "sign";
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(@RequestParam String username,@RequestParam String password,
                            @RequestParam String mobile,@RequestParam String address
                            ){

        Customer c = new Customer(username,password,mobile,address);
        customerService.signUp(c);
        return "login";
    }

    @RequestMapping(value = "signInerror", method = RequestMethod.GET)
    @ResponseBody
    public String signInError(){
        return "用户名或者密码错误";
    }


    @RequestMapping(value="applyforvip",method=RequestMethod.GET)
    public String applyForVip(Model model,HttpSession session){
        model.addAttribute("vip", "正在处理中");
        Customer user = (Customer) session.getAttribute("user");
        MsgBean msgBean = new MsgBean("1",null,user.getId());

        model.addAttribute("user", user);
        model.addAttribute("courses", courseService.getAll());
        System.out.println(msgBean.toString());
        kafkaProducer.sendMessageToMemberTopic(JSON.toJSONString(msgBean));
        return "home"; 
    }

    @GetMapping(value="applyforclass/{id}")
    public String applyForClass(@PathVariable(name = "id") String id,Model model,HttpSession session){
        
        Customer user = (Customer) session.getAttribute("user");
        MsgBean msgBean = new MsgBean("1",id,user.getId());

        model.addAttribute("user", user);
        model.addAttribute("courses", courseService.getAll());
        
        kafkaProducer.sendMessageToCourseTopic(JSON.toJSONString(msgBean));

        return "applyforclass"; 
    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public String list(){
        String s = JSON.toJSONString(customerService.getAll());
        return s;
    }

}