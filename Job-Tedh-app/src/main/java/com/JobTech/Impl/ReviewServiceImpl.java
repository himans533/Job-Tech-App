package com.JobTech.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.JobTech.Dto.Company;
import com.JobTech.Dto.Review;
import com.JobTech.Repository.ReviewRepository;
import com.JobTech.Service.CompanyService;
import com.JobTech.Service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	private final ReviewRepository reviewRepository;
	private final CompanyService companyService;
	

	public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
		this.reviewRepository = reviewRepository;
		this.companyService = companyService;
	}

	@Override
	public List<Review> getAllReviews(Long companyId) {
		List<Review> reviews = reviewRepository.findByCompanyId(companyId);
		return reviews;
	}

	@Override
	public void addReview(Long companyId ,Review review) {
		Company company = companyService.getCompanyById(companyId);
		
		if(company != null) {
			review.setCompany(company);
			reviewRepository.save(review);
		}
	}

}
