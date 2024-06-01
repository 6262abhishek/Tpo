package com.TPO.restapi.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TPO.restapi.model.Student;
import com.TPO.restapi.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmailService emailService;
	
	 public void registerStudent(Student student) {
	        String otp = generateOtp();
	        student.setOtp(otp);
	        student.setVerified(false);
	        studentRepository.save(student);
	        emailService.sendOtpEmail(student.getEmail(), otp);
	    }
	    public void verifyOtp(String email, String otp) {
	        Student student = studentRepository.findBYEmail(email);
	        if (student != null && student.getOtp().equals(otp)) {
	            student.setVerified(true);
	            studentRepository.save(student);
	        }
	    }
	    
	    public void updateProfile(Student student) {
	        studentRepository.save(student);
	    }

	    private String generateOtp() {
	        Random random = new Random();
	        return String.format("%04d", random.nextInt(10000));
	    }

}
