package com.JobTech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JobTech.Dto.Company;


public interface CompanyRepository extends JpaRepository<Company, Long> {

}