package com.uok.sams.controllers;

import com.uok.sams.exception.ApiRequestException;
import com.uok.sams.models.Attendance;
import com.uok.sams.payload.request.AttendanceRequest;
import com.uok.sams.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;


    @PostMapping("/attendance")
    public ResponseEntity<Long> makeAttendanceRequest(@RequestBody AttendanceRequest attendanceRequest){
        return new ResponseEntity<Long>(attendanceService.addAttendanceRecode(attendanceRequest), HttpStatus.ACCEPTED);
    }

}
