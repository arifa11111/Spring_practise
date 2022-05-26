package com.Thymeleaf.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model theModel) {
        return "home";
    }

    @GetMapping("/book")
    public String book(Model theModel) {
        System.out.println("entering boooooooooooooooooooooooooooook");
        return "book-ticket";
    }

    @GetMapping("/bookedSuccess")
    public String booked(Model theModel) {
        return "book-success";
    }
}
