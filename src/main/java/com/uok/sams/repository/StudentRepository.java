package com.uok.sams.repository;

import com.uok.sams.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long > {

    @Nullable
    Student findByStudentNo(String studentNo);

    Optional<Student> findById(Long studentId);
}
