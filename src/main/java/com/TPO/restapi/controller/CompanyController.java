package com.TPO.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TPO.restapi.model.Company;
import com.TPO.restapi.service.CompanyService;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/register")
	public ResponseEntity<String>registercompany(@RequestBody Company company) {
		companyService.registerCompany(company);
		return ResponseEntity.ok("Company registered successfully");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompany(@PathVariable Long id) {
	        Company company = companyService.getCompany(id);
	        return ResponseEntity.ok(company);
	   }
}
