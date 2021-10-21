package com.uok.sams.payload.request;

import java.util.Date;

public class AttendanceRequest {
    private Long studentId;
    private Long locationId;
    private Date timeStamp;
    private Long qrClientId;
    private Long qrClientStaffId;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Long getQrClientId() {
        return qrClientId;
    }

    public void setQrClientId(Long qrClientId) {
        this.qrClientId = qrClientId;
    }

    public Long getQrClientStaffId() {
        return qrClientStaffId;
    }

    public void setQrClientStaffId(Long qrClientStaffId) {
        this.qrClientStaffId = qrClientStaffId;
    }
}
