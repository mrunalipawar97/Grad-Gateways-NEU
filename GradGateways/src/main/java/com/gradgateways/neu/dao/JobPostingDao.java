package com.gradgateways.neu.dao;

import java.util.List;
import com.gradgateways.neu.model.JobPosting;

/**
*
* @author mrunalipawar
* interface : JobPostingDao
*/

public interface JobPostingDao {

	List<JobPosting> findJobPostingByEmployerName(String employerName) throws Exception;
	
	JobPosting findJobPostingById(Long jobId) throws Exception;
	
	List<JobPosting> findAllJobPosting() throws Exception;

	void saveJobPosting(JobPosting student) throws Exception;

	void deleteJobPosting(JobPosting student) throws Exception;

	void deleteAllJobPosting(String employerName) throws Exception;
}
