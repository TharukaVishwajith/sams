package com.uok.sams.service.impl;

import com.uok.sams.exception.StudentNotFoundException;
import com.uok.sams.models.Student;
import com.uok.sams.repository.StudentRepository;
import com.uok.sams.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudentById(Long studentId) {
        Optional<Student> s = studentRepository.findById(studentId);
        if(s.isEmpty()) {
            throw new StudentNotFoundException(
                    "No student found with Id: " + studentId,
                    HttpStatus.NO_CONTENT,
                    ZonedDateTime.now(ZoneId.of("UTC")));
        }
        return s.get();
    }

    @Override
    public Student getStudentByStudentNo(String studentNo) throws StudentNotFoundException{
        Student s = studentRepository.findByStudentNo(studentNo);
        if(s == null) {
            throw new StudentNotFoundException(
                    "No student found with No: " + studentNo,
                    HttpStatus.NO_CONTENT,
                    ZonedDateTime.now(ZoneId.of("UTC")));
        }
        return s;
    }
}
