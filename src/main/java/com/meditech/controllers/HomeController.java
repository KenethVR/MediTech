package com.meditech.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Add methods to handle requests here
    // For example, you can add a method to return the home page view

    @GetMapping({ "", "/", "/home", "/index" })
    public String home() {
        return "index"; // This should correspond to a view template named "index.html"
    }

}
