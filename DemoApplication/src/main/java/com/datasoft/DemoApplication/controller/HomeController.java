package com.datasoft.DemoApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    //@RequestMapping(value = "/", method = RequestMethod.GET)
//    @GetMapping(value = "/")
//    public String welcomePage(Model model) {
//        model.addAttribute("title", "Welcome to Smart Meter Backoffice");
//        return "home/home";
//    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("title", "Welcome to Smart Meter Backoffice");
        return "login/login";
    }
}