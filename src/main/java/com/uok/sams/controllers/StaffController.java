package com.uok.sams.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffController {

    @RequestMapping("/api/auth/hi")
    public String hello(){
        return "Hi";
    }

}