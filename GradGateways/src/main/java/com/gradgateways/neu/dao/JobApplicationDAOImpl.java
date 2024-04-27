package com.gradgateways.neu.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import com.gradgateways.neu.model.JobApplication;

/**
*
* @author mrunalipawar
* class : JobApplicationDAOImpl
*/
@Component
public class JobApplicationDAOImpl extends ConnectionDAO implements JobApplicationDao {

	@Override
	public void saveJobApplication(JobApplication jobApplication) throws Exception {
		try {
			beginHibernateTransaction();
			getActiveSession().save(jobApplication);
			commitTransaction();
		} catch (HibernateException e) {
			rollbackTransaction();
			e.printStackTrace();
			throw new Exception("Could not save job application " + jobApplication.getJob(), e);
		}
	}

	@Override
	public JobApplication findJobApplicationById(Long applicationId) throws Exception {
		try {
			
			beginHibernateTransaction();
			JobApplication jobApplication = (JobApplication) getActiveSession().get(JobApplication.class, applicationId);
			System.out.println("Starting update transaction for application ID: " + jobApplication.getApplicationId());
			commitTransaction();
			return jobApplication;
		} catch (HibernateException e) {
			rollbackTransaction();
			e.printStackTrace();
			throw new Exception("Could not fetch the job application with id " + applicationId, e);
		}
	}

	@Override
	public void updateJobApplication(JobApplication jobApplication) throws Exception {
		try {
			beginHibernateTransaction();
			getActiveSession().update(jobApplication);
			commitTransaction();
		} catch (HibernateException e) {
			rollbackTransaction();
			e.printStackTrace();
			throw new Exception("Could not update job application " + jobApplication.getJob(), e);
		}

	}

	@Override
	public List<JobApplication> findPendingJobApplication(String employerName) throws Exception {

		List<JobApplication> jobApplications;

		try {
			Criteria criteria = getActiveSession().createCriteria(JobApplication.class);
			criteria.add(Restrictions.eq("employerName", employerName));
			criteria.add(Restrictions.eq("applied", false));
			jobApplications = (List<JobApplication>) criteria.list();
		} catch (HibernateException e) {
			rollbackTransaction();
			throw new Exception("Error fetching job applications for " + employerName, e);
		}
		System.out.println("Applications list: " + jobApplications);
		return jobApplications;
	}

	@Override
	public List<JobApplication> findJobApplicationByEmployerName(String employerName) throws Exception {

		List<JobApplication> jobApplications;

		try {
			Criteria criteria = getActiveSession().createCriteria(JobApplication.class);
			criteria.add(Restrictions.eq("employerName", employerName));
			System.out.println("findByEmployerName : jobapplicationdao " + employerName);
			jobApplications = (List<JobApplication>) criteria.list();
			System.out.println("findByEmployerName : jobapplicationdao " + jobApplications);
		} catch (HibernateException e) {
			rollbackTransaction();
			throw new Exception("Error fetching job applications for " + employerName, e);
		}
		System.out.println("findByEmployerName : jobapplicationdao " + jobApplications);
		return jobApplications;
	}

	@Override
	public void deleteAllJobApplication(String employerName) throws Exception {
		try {
			beginHibernateTransaction();
			Query query = getActiveSession().createQuery("DELETE from JobApplications where employerName= :employerName");
			query.setString("employerName", employerName);
			query.executeUpdate();
			commitTransaction();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new Exception("Could not delete : " + employerName, e);
		}
	}

	@Override
	public List<JobApplication> findJobApplicationByStudentName(String studentName) throws Exception {
		List<JobApplication> jobApplications;

		try {
			Criteria criteria = getActiveSession().createCriteria(JobApplication.class);
			criteria.add(Restrictions.eq("studentName", studentName));
			jobApplications = (List<JobApplication>) criteria.list();
		} catch (HibernateException e) {
			rollbackTransaction();
			throw new Exception("Error fetching job applications for " + studentName, e);
		}
		System.out.println("findByStudentName : jobapplicationdao " + jobApplications);
		return jobApplications;
	}
	
	public boolean hasStudentAppliedToJob(String studentName, Long jobId) throws Exception {	    
	    try {
	        List<JobApplication> applications = findJobApplicationByStudentName(studentName);
	        for (JobApplication application : applications) {
	            if (application.getJob().getId().equals(jobId)) {
	                return true;
	            }
	        }
	        return false;
	    } catch (HibernateException e) {
	        e.printStackTrace();
	        throw new Exception("Error while checking if student has applied to job", e);
	    }
	}

}
