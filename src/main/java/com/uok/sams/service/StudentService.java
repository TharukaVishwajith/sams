package com.uok.sams.service;

import com.uok.sams.exception.StudentNotFoundException;
import com.uok.sams.models.Student;

public interface StudentService {

    Student getStudentById(Long studentId) throws StudentNotFoundException;

    Student getStudentByStudentNo(String studentNo) throws StudentNotFoundException;
}
