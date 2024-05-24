package com.JobTech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.JobTech.Dto.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

}
