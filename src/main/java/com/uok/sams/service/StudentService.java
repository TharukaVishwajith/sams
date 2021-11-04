package com.uok.sams.service;

import com.uok.sams.exception.StudentNotFoundException;
import com.uok.sams.models.Student;
import com.uok.sams.payload.request.StudentImageRequest;

public interface StudentService {

    Student getStudentById(Long studentId) throws StudentNotFoundException;

    Student getStudentByStudentNo(String studentNo) throws StudentNotFoundException;

    Student createNewStudent(Student student);

    Long addStudentImage(StudentImageRequest studentImage);
}
