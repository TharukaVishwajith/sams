package com.uok.sams.service;

import com.uok.sams.payload.request.AttendanceRequest;


public interface AttendanceService {
    Integer addAttendanceRecode(AttendanceRequest attendanceRequest);
}
