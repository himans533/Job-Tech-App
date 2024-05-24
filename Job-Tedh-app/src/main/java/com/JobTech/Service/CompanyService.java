package com.JobTech.Service;

import java.util.List;

import com.JobTech.Dto.Company;

public interface CompanyService {

	List <Company> findAll();
	
	void createCompany(Company company);
	
	Company getCompanyById( Long id);
	
	boolean getdeleteById( Long id);
	
	boolean updateCompany( Long id , Company updateCompany);

}
