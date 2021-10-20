package com.uok.sams.models;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity(name = "staff")
public class Staff extends BaseEntity{

    @OneToOne(mappedBy = "staff")
    private User user;

    private String name;

    @Column(name = "staff_no")
    private String staffNo;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "personal_email")
    private String personalEmail;

    @Column(name = "uni_email")
    private String uniEmail;

    @Column(name = "personal_contact_number")
    private Integer personalContactNumber;

    @Column(name = "uni_contact_number")
    private Integer uniContactNumber;

    @Column(name = "home_contact_number")
    private Integer homeContactNumber;

    @Column(name = "position")
    private String position;

    @Column(name = "image_url")
    private String imageUrl;

    //    TODO: Migrate Blob data to a image repository
    @Lob
    @Column(name = "image_data")
    private Blob imageData;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getUniEmail() {
        return uniEmail;
    }

    public void setUniEmail(String uniEmail) {
        this.uniEmail = uniEmail;
    }

    public Integer getPersonalContactNumber() {
        return personalContactNumber;
    }

    public void setPersonalContactNumber(Integer personalContactNumber) {
        this.personalContactNumber = personalContactNumber;
    }

    public Integer getUniContactNumber() {
        return uniContactNumber;
    }

    public void setUniContactNumber(Integer uniContactNumber) {
        this.uniContactNumber = uniContactNumber;
    }

    public Integer getHomeContactNumber() {
        return homeContactNumber;
    }

    public void setHomeContactNumber(Integer homeContactNumber) {
        this.homeContactNumber = homeContactNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
