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

import com.JobTech.Dto.Job;
import com.JobTech.Service.JobService;

@RestController
public class JobController {

	private JobService jobService;

	
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}
	
	@GetMapping("/jobs")
   public ResponseEntity<List<Job>> findAll(){
	return ResponseEntity.ok(jobService.findAll());
	   
   }
   
	@PostMapping("/jobs")
   public ResponseEntity<String> createJob(@RequestBody Job job) {
	jobService.createJob(job);
	return new ResponseEntity<>("Job Add Successfully" , HttpStatus.OK);
	   
   }
	
	@GetMapping("/jobs/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable Long id) {
		Job job= jobService.getJobById(id);
		if(job != null) 
			return new ResponseEntity<>(job ,HttpStatus.OK);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@DeleteMapping("/jobs/{id}")
	public ResponseEntity<String> deleteJobById(@PathVariable Long id){
		boolean deleted=jobService.deleteJobById(id);
		if(deleted)
			return new ResponseEntity<String>("Job delete Successfully" ,HttpStatus.OK);
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	
	@PutMapping("/jobs/{id}")
	public ResponseEntity<String> updateJob(@PathVariable Long id ,@RequestBody Job updateJob){
		
		boolean updated = jobService.updateJob(id , updateJob);
		
		if(updated)
			return new ResponseEntity<String>("Job update Successfully" , HttpStatus.OK);
			
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
}

