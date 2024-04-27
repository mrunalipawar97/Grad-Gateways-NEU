package com.gradgateways.neu.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import com.gradgateways.neu.model.JobPosting;

/**
*
* @author mrunalipawar
* class : JobPostingDAOImpl
*/

@Component
public class JobPostingDAOImpl extends ConnectionDAO implements JobPostingDao {
	
	@Override
	public void saveJobPosting(JobPosting jobPosting) throws Exception {
		try {
			beginHibernateTransaction();
			getActiveSession().save(jobPosting);
			commitTransaction();
		} catch (HibernateException e) {
			rollbackTransaction();
			e.printStackTrace();
			throw new Exception("Could not save job " + jobPosting.getJobtitle(), e);
		}
	}

	@Override
	public void deleteJobPosting(JobPosting jobPosting) throws Exception {
		beginHibernateTransaction();
		getActiveSession().delete(jobPosting);
		commitTransaction();
	}

	@Override
	public void deleteAllJobPosting(String employerName) throws Exception {

		try {
			beginHibernateTransaction();
			Query query = getActiveSession().createQuery("DELETE from JobPosting where employerName = :employerName");
			query.setString("employerName", employerName);
			query.executeUpdate();
			commitTransaction();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new Exception("Could not delete job with employerName : " + employerName, e);
		}
	}

	@Override
	public List<JobPosting> findJobPostingByEmployerName(String employerName) throws Exception {

		List<JobPosting> list = null;

		Criteria criteria = getActiveSession().createCriteria(JobPosting.class);
		criteria.add(Restrictions.eq("employerName", employerName));
		list = (List<JobPosting>) criteria.list();
		return list;
	}
	
	@Override
	public List<JobPosting> findAllJobPosting() throws Exception {
		List<JobPosting> list = null;
		Criteria criteria = getActiveSession().createCriteria(JobPosting.class);
		list = (List<JobPosting>) criteria.list();
		return list;
	}

	@Override
	public JobPosting findJobPostingById(Long jobId) throws Exception {
		try {
			beginHibernateTransaction();
			JobPosting jobPosting = (JobPosting) getActiveSession().get(JobPosting.class, jobId);
			commitTransaction();
			return jobPosting;
		} catch (HibernateException e) {
			rollbackTransaction();
			e.printStackTrace();
			throw new Exception("Could not fetch the job posting with id " + jobId, e);
		}
	}

}
