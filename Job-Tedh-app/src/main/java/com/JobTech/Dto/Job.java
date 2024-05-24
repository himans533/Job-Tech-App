package com.JobTech.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Job_Table")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String decription;
	private String minsalary;
	private String maxsalary;
	private String location;
	
	@ManyToOne
	private Company company;
	
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public String getMinsalary() {
		return minsalary;
	}
	public void setMinsalary(String minsalary) {
		this.minsalary = minsalary;
	}
	public String getMaxsalary() {
		return maxsalary;
	}
	public void setMaxsalary(String maxsalary) {
		this.maxsalary = maxsalary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Job(Long id, String title, String decription, String minsalary, String maxsalary, String location) {
		this.id = id;
		this.title = title;
		this.decription = decription;
		this.minsalary = minsalary;
		this.maxsalary = maxsalary;
		this.location = location;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", decription=" + decription + ", minsalary=" + minsalary
				+ ", maxsalary=" + maxsalary + ", location=" + location + "]";
	}
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}