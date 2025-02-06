package com.example.simpleWebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // REST -> representational state transfer
public class HomeController {

    @RequestMapping("/") //homepage
    public String greet() {
        return "welcome to web app";
    }

    @RequestMapping("/about") //about
    public String about() {
        return "this is about page";
    }

    @RequestMapping("/contacts") //contatti
    public String contacts() {
        return "this is contacts page";
    }

}
