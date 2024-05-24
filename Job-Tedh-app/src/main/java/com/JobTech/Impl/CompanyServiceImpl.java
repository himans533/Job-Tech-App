package com.JobTech.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.JobTech.Dto.Company;
import com.JobTech.Repository.CompanyRepository;
import com.JobTech.Service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

   CompanyRepository  companyRepository;
	
	private Long nextId = 1L;
	
	

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> findAll() {		
		return companyRepository.findAll();
	}

	@Override
	public void createCompany(Company company) {
		company.setId(nextId++);
		companyRepository.save(company);	
	}
	
	@Override
	public Company getCompanyById(Long id) {
		return companyRepository.findById(id).orElse(null);
		
	}

	@Override
	public boolean getdeleteById(Long id) {
		try {
			companyRepository.deleteById(id);
			return true;
		}
		catch(Exception e) {
		return false;
	}
	}

	@Override
	public boolean updateCompany(Long id, Company updateCompany) {
	     Optional <Company> companyOptional = companyRepository.findById(id);
	     if(companyOptional.isPresent()) {
	    	 Company company=companyOptional.get();
	    	 if(company.getId().equals(id)) {
	    		 company.setTitle(updateCompany.getTitle());
	    		 company.setDecription(updateCompany.getDecription());
	    		 return true;
	    	 }
	     }
		return false;
	}
	
}
