package com.uok.sams.service;

import com.uok.sams.exception.StudentNotFoundException;
import com.uok.sams.models.Staff;
import com.uok.sams.payload.request.StaffImageRequest;
import com.uok.sams.payload.request.StudentImageRequest;

public interface StaffService {

    Staff getStaffById(Long staffId) throws StudentNotFoundException;

    Staff getStaffByStaffNo(String staffNo) throws StudentNotFoundException;

    Staff createNewStaff(Staff staff);

    Long addStaffImage(StaffImageRequest staffImage);
}
