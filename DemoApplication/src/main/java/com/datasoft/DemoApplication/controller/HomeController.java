package com.datasoft.DemoApplication.controller;

import com.datasoft.DemoApplication.model.User;
import com.datasoft.DemoApplication.repository.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Slf4j
@Controller
public class HomeController {

    //@RequestMapping(value = "/", method = RequestMethod.GET)
//    @GetMapping(value = "/")
//    public String welcomePage(Model model) {
//        model.addAttribute("title", "Welcome to Smart Meter Backoffice");
//        return "home/home";
//    }


    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("title", "Welcome to Smart Meter Backoffice");
        List<User> userList = userDao.findAll();
        System.out.println(userList.toString());
        return "login/login";
    }

    @RequestMapping(value = "/userData", method = RequestMethod.GET)
    public String userData(Model model) {
//        model.addAttribute("title", "Welcome to Smart Meter Backoffice");
        List<User> userList = userDao.findAll();
        System.out.println(userList.toString());
        return "login/login";
    }
}