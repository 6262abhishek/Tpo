package com.TPO.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TPO.restapi.model.Company;
import com.TPO.restapi.repository.CompanyRepository;

@Service
public class CompanyService {
	@Autowired
	private CompanyRepository companyRepository;
	
	public void registerCompany(Company company) {
		companyRepository.save(company);
	}
	public Company getCompany(Long id) {
		return companyRepository.findById(id).orElse(null);
	}
}
