package com.JobTech.Impl;

import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.JobTech.Dto.Job;
import com.JobTech.Repository.JobRepository;
import com.JobTech.Service.JobService;

@Service
public class JobServiceImpl implements JobService{
//	private List<Job> jobs =new ArrayList<>();
	
	JobRepository  jobRepository;
	
	private Long nextId = 1L;
	
	

	public JobServiceImpl(JobRepository jobRepository) {
		super();
		this.jobRepository = jobRepository;
	}

	@Override
	public List<Job> findAll() {		
		return jobRepository.findAll();
	}

	@Override
	public void createJob(Job job) {
		job.setId(nextId++);
		jobRepository.save(job);	
	}

	@Override
	public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
	}
	
	@Override
	public boolean deleteJobById(Long id) {
		try {
		 jobRepository.deleteById(id);
		 return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateJob(Long id, Job updateJob) {
		Optional<Job> jobOptional= jobRepository.findById(id);
	   if(jobOptional.isPresent())	{
		   Job job =jobOptional.get();
			if(job.getId().equals(id)) {
				job.setTitle(updateJob.getTitle());
				job.setDecription(updateJob.getDecription());
				job.setMaxsalary(updateJob.getMaxsalary());
				job.setMinsalary(updateJob.getMinsalary());
				job.setLocation(updateJob.getLocation());
				return true;
			}
		}
		return false;
	}
	
}
