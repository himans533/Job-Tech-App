package com.JobTech.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String Decription;
	
	@JsonIgnore
	@OneToMany(mappedBy = "company")
	private List<Job> jobs;
	
	@OneToMany(mappedBy = "company")
	private List<Review> review;
	
	
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long nextId) {
		this.id = nextId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDecription() {
		return Decription;
	}
	public void setDecription(String decription) {
		Decription = decription;
	}
	
	public List<Review> getReview() {
		return review;
	}
	public void setReview(List<Review> review) {
		this.review = review;
	}
	
	public Company(Long id, String title, String decription, List<Job> jobs, List<Review> review) {
		super();
		this.id = id;
		this.title = title;
		Decription = decription;
		this.jobs = jobs;
		this.review = review;
	}
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
