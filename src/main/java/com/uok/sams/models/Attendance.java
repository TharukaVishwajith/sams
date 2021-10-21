package com.uok.sams.models;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "attendance")
public class Attendance extends BaseEntity{

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time_stamp")
    private Date timeStamp;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "qr_client_id")
    private QRClient qrClient;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "recorded_by")
    private User recordedBy;

    public Attendance(Date timeStamp, Student student, QRClient qrClient, Location location, User recordedBy) {
        this.timeStamp = timeStamp;
        this.student = student;
        this.qrClient = qrClient;
        this.location = location;
        this.recordedBy = recordedBy;
    }

    public Attendance() {
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public QRClient getQrClient() {
        return qrClient;
    }

    public void setQrClient(QRClient qrClient) {
        this.qrClient = qrClient;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public User getRecordedBy() {
        return recordedBy;
    }

    public void setRecordedBy(User recordedBy) {
        this.recordedBy = recordedBy;
    }
}
