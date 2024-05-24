package com.JobTech.Controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.JobTech.Dto.Company;
import com.JobTech.Service.CompanyService;

@RestController
public class CompanyController {

	private CompanyService companyService;
		
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}


	@GetMapping("/company")
	 public ResponseEntity<List<Company>> findAll(){
		return ResponseEntity.ok(companyService.findAll());
		   
	   }
	@PostMapping("/company")
	 public ResponseEntity<String> createJob(@RequestBody Company company) {
			companyService.createCompany(company);
			return new ResponseEntity<>("Job Add Successfully" , HttpStatus.OK);
			   
		   }
	
	@GetMapping("/company/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
		Company company= companyService.getCompanyById(id);
		
		if (company != null) 
			return new ResponseEntity<>(company , HttpStatus.OK);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
	}
	
	@DeleteMapping("/company/{id}")	
	public ResponseEntity<String> deleteCompanyById( Long id) {	    
		boolean deleted = companyService.getdeleteById(id);	  
		
	     if(deleted) 
	    	 return new ResponseEntity<String>("Company deleted Successfully " , HttpStatus.OK);	    	 
	    	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
	}
	
	@PutMapping("/company/{id}")
	public ResponseEntity<String> updateCompany(@PathVariable  Long id ,@RequestBody Company updateCompany){
		boolean updated = companyService.updateCompany(id , updateCompany);
		
		if(updated) 
			return new ResponseEntity<String>("Company Updated Seccessfully" , HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
