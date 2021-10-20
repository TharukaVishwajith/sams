package com.uok.sams.models;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity(name = "student")
public class Student extends BaseEntity{

    @Column(unique=true, name = "student_no")
    private String studentNo;

    @Column(unique=true, name = "nic_no")
    private String nicNo;

    @Temporal(TemporalType.DATE)
    @Column(name = "dob")
    private Date dob;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "province")
    private Province province;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "district")
    private District district;

    @Column(name = "address")
    private Province address;

    @Column(name = "postal_code")
    private Integer postalCode;

    @Column(name = "year")
    private Integer year;

    @Column(name = "personal_email")
    private String personalEmail;

    @Column(name = "uni_email")
    private String uniEmail;

    @Column(name = "personal_contact_number")
    private Integer personalContactNumber;

    @Column(name = "home_contact_number")
    private Integer homeContactNumber;

    @Column(name = "image_url")
    private String imageUrl;

    //    TODO: Migrate Blob data to a image repository
    @Lob
    @Column(name = "image_data")
    private Blob imageData;

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public Integer getHomeContactNumber() {
        return homeContactNumber;
    }

    public void setHomeContactNumber(Integer homeContactNumber) {
        this.homeContactNumber = homeContactNumber;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Province getAddress() {
        return address;
    }

    public void setAddress(Province address) {
        this.address = address;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }
}