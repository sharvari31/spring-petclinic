package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String showMessage() {
        return " Pet Clinic Application A087 Sharvari Exam";
    }
}
