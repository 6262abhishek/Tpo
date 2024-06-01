package com.TPO.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TPO.restapi.model.Company;

public interface CompanyRepository extends JpaRepository <Company, Long>{
	
}
