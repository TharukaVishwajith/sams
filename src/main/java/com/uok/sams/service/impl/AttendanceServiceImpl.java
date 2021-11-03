package com.uok.sams.service.impl;

import com.uok.sams.models.Attendance;
import com.uok.sams.payload.request.AttendanceRequest;
import com.uok.sams.repository.AttendanceRepository;
import com.uok.sams.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    AttendanceRepository attendanceRepository;

    @Transactional
    @Override
    public Integer addAttendanceRecode(AttendanceRequest attendanceRequest) {
        Attendance attendance = new Attendance();
        Date now = Date.from(Instant.now());
        attendance.setUpdatedDate(now);
        attendance.setCreatedDate(now);
        return attendanceRepository.insertAttendance(
                attendanceRequest.getTimeStamp(),
                attendanceRequest.getLocationId(),
                attendanceRequest.getQrClientId(),
                attendanceRequest.getLocationId(),
                attendanceRequest.getStudentId(),
                now, now
        );
    }


}
