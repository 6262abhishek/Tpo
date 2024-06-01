package com.TPO.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.TPO.restapi.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	Student findBYEmail(String email);
}
