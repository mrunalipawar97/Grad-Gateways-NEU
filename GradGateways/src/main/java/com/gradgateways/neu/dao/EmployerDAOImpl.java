package com.gradgateways.neu.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.gradgateways.neu.model.Employer;

/**
*
* @author mrunalipawar
* class : EmployerDAOImpl
*/
@Component
public class EmployerDAOImpl extends ConnectionDAO implements EmployerDao {

	@Override
	public List<Employer> findAllEmployers() {
		Query<Employer> query = getActiveSession().createQuery("FROM Employer ");
		List<Employer> list = query.list();
		return list;
	}

	@Override
	public void saveEmployer(Employer employer) throws Exception {
		try {
			beginHibernateTransaction();
			getActiveSession().save(employer);
			commitTransaction();
		} catch (HibernateException e) {
			rollbackTransaction();
			throw new Exception("Could not save Employer " + employer.getEmployerName(), e);
		}

	}

	@Override
	public Employer findEmployerByEmail(String email) throws Exception {
		Employer employer;

		try {
			Criteria criteria = getActiveSession().createCriteria(Employer.class);
			criteria.add(Restrictions.eq("employerEmail", email));
			employer = (Employer) criteria.uniqueResult();

		} catch (HibernateException e) {
			rollbackTransaction();
			throw new Exception("Error fetching Employer: " + email, e);
		}
		return employer;
	}

	@Override
	public void deleteEmployer(Employer employer) {
		try {
			beginHibernateTransaction();
	        getActiveSession().delete(employer);
	        commitTransaction();
	    } catch (HibernateException e) {
	        rollbackTransaction();
	        throw new RuntimeException("Cannot delete student: " + employer.getId(), e);
	    }
	}

	@Override
	public void updateEmployer(Employer employer) throws Exception {
		if (employer.getId() == 0) {
	        throw new Exception("Attempted to update an employer with id 0");
	    }
	    try {
	    	beginHibernateTransaction();
	        System.out.println("Updating employer with ID: " + employer.getId());
	        getActiveSession().update(employer);
	        commitTransaction();
	    } catch (HibernateException e) {
	        rollbackTransaction();
	        throw new Exception("Could not update employer " + employer.getEmployerName(), e);
	    }
	}
}