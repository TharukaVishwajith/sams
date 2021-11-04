package com.uok.sams.controllers;

import com.uok.sams.models.Student;
import com.uok.sams.payload.request.StudentImageRequest;
import com.uok.sams.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{studentNo}")
    public ResponseEntity<Student> getStudent(@PathVariable String studentNo){
       return new ResponseEntity<>(studentService.getStudentByStudentNo(studentNo), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.createNewStudent(student), HttpStatus.OK);
    }

    @PatchMapping(path = "/profileImage" ,consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Long> addStudentImage(@ModelAttribute StudentImageRequest studentImage){
        return new ResponseEntity<>(studentService.addStudentImage(studentImage), HttpStatus.OK);
    }
}
