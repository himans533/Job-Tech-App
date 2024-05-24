package com.JobTech.Service;

import java.util.List;

import com.JobTech.Dto.Review;

public interface ReviewService {

	List<Review> getAllReviews (Long companyId);

	void addReview(Long companyId, Review review);
	
}
