package com.uok.sams.controllers;

import com.uok.sams.models.Staff;
import com.uok.sams.payload.request.StaffImageRequest;
import com.uok.sams.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/{staffNo}")
    public ResponseEntity<Staff> getStaff(@PathVariable String staffNo){
        return new ResponseEntity<>(staffService.getStaffByStaffNo(staffNo), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Staff> createStaff(@RequestBody Staff staff){
        return new ResponseEntity<>(staffService.createNewStaff(staff), HttpStatus.OK);
    }

    @PatchMapping(path = "/profileImage" ,consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Long> addStudentImage(@ModelAttribute StaffImageRequest studentImage){
        return new ResponseEntity<>(staffService.addStaffImage(studentImage), HttpStatus.OK);
    }

}
