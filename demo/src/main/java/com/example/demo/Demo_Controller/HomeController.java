package com.example.demo.Demo_Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${welcome.message}") //using custom message from application.properties..
    private String message;

    @GetMapping("/")
    public String home(){
        return message;
    }
}
