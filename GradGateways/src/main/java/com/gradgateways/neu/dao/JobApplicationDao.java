package com.gradgateways.neu.dao;

import java.util.List;
import com.gradgateways.neu.model.JobApplication;

/**
*
* @author mrunalipawar
* interface : JobApplicationDao
*/

public interface JobApplicationDao {

	void saveJobApplication(JobApplication jobApplication) throws Exception;

	JobApplication findJobApplicationById(Long applicationId) throws Exception;

	void updateJobApplication(JobApplication jobApplication) throws Exception;

	List<JobApplication> findPendingJobApplication(String employerName) throws Exception;

	List<JobApplication> findJobApplicationByEmployerName(String employerName) throws Exception;
	
	List<JobApplication> findJobApplicationByStudentName(String studentName) throws Exception;

	void deleteAllJobApplication(String employerName) throws Exception;
}
