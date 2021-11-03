package com.uok.sams.controllers;

import com.uok.sams.models.Student;
import com.uok.sams.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{studentNo}")
    public ResponseEntity<Student> getStudent(@PathVariable String studentNo){
       return new ResponseEntity<>(studentService.getStudentByStudentNo(studentNo), HttpStatus.OK);
    }
}
