package com.TPO.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TPO.restapi.model.Student;
import com.TPO.restapi.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	 private StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestBody Student student) {
        studentService.registerStudent(student);
        return ResponseEntity.ok("Registration successful, check your email for OTP");
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyOtp(@RequestParam String email, @RequestParam String otp) {
        studentService.verifyOtp(email, otp);
        return ResponseEntity.ok("Verification successful");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateProfile(@RequestBody Student student) {
        studentService.updateProfile(student);
        return ResponseEntity.ok("Profile updated successfully");
    }
}