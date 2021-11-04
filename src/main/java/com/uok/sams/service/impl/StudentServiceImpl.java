package com.uok.sams.service.impl;

import com.uok.sams.exception.StudentNotFoundException;
import com.uok.sams.models.Student;
import com.uok.sams.payload.request.StudentImageRequest;
import com.uok.sams.repository.StudentRepository;
import com.uok.sams.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
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

    @Override
    public Student createNewStudent(Student student) {
        Date now = Date.from(Instant.now());
        student.setUpdatedDate(now);
        student.setCreatedDate(now);
        return studentRepository.save(student);
    }

    @Override
    public Long addStudentImage(StudentImageRequest studentImage) {
        Student student = studentRepository.findByStudentNo(studentImage.getStudentNo());
        student.setImageUrl(studentImage.getImageUrl());
        try {
            student.setImageData(studentImage.getImageData().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentRepository.save(student).getId();
    }
}
