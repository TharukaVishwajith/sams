package com.uok.sams.controllers;

import com.uok.sams.exception.ApiRequestException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AttendanceController {


    @PostMapping("/attendance")
    public String hi(){
        throw new ApiRequestException("no student");
//        return "Hello";
    }

}
