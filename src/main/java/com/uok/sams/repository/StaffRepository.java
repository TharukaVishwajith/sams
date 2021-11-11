package com.uok.sams.repository;

import com.uok.sams.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Long> {

    @Nullable
    Staff findByStaffNo(String studentNo);

    Optional<Staff> findById(Long studentId);
}
