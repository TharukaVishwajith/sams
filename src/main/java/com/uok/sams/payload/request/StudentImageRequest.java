package com.uok.sams.payload.request;

import org.springframework.web.multipart.MultipartFile;


public class StudentImageRequest {
    private String studentNo;
    private String imageUrl;
    private MultipartFile imageData;

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public MultipartFile getImageData() {
        return imageData;
    }

    public void setImageData(MultipartFile imageData) {
        this.imageData = imageData;
    }
}
