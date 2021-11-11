package com.uok.sams.service.impl;

import com.uok.sams.exception.EntityNotFoundException;
import com.uok.sams.exception.StudentNotFoundException;
import com.uok.sams.models.Staff;
import com.uok.sams.payload.request.StaffImageRequest;
import com.uok.sams.repository.StaffRepository;
import com.uok.sams.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Staff getStaffById(Long studentId) {
        Optional<Staff> s = staffRepository.findById(studentId);
        if(s.isEmpty()) {
            throw new StudentNotFoundException(
                    "No student found with Id: " + studentId,
                    HttpStatus.NO_CONTENT,
                    ZonedDateTime.now(ZoneId.of("UTC")));
        }
        return s.get();
    }

    @Override
    public Staff getStaffByStaffNo(String staffNo) throws EntityNotFoundException {
        Staff s = staffRepository.findByStaffNo(staffNo);
        if(s == null) {
            throw new EntityNotFoundException(
                    "No staff found with No: " + staffNo,
                    HttpStatus.NO_CONTENT,
                    ZonedDateTime.now(ZoneId.of("UTC")));
        }
        return s;
    }

    @Override
    public Staff createNewStaff(Staff staff) {
        Date now = Date.from(Instant.now());
        staff.setUpdatedDate(now);
        staff.setCreatedDate(now);
        return staffRepository.save(staff);
    }

    @Override
    public Long addStaffImage(StaffImageRequest staffImage) {
        Staff staff = staffRepository.findByStaffNo(staffImage.getStaffNo());
        staff.setImageUrl(staffImage.getImageUrl());
        try {
            staff.setImageData(staffImage.getImageData().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return staffRepository.save(staff).getId();
    }
}
