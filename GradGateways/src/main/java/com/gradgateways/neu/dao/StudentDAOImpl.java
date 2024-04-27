package com.gradgateways.neu.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import com.gradgateways.neu.model.Student;

/**
*
* @author mrunalipawar
* class : StudentDAOImpl 
*/

@Component
public class StudentDAOImpl extends ConnectionDAO implements StudentDao {

	@Override
	public List<Student> findAll() {
		Query<Student> query = getActiveSession().createQuery("FROM Student");
		List<Student> list = query.getResultList();
		return list;
	}

	@Override
	public void saveStudent(Student student) throws Exception {
		try {
			beginHibernateTransaction();
			getActiveSession().save(student);
			commitTransaction();
		} catch (HibernateException e) {
			rollbackTransaction();
			throw new Exception("Could not delete user " + student.getName(), e);
		}
	}

	@Override
	public Student findStudentByName(String name) throws Exception {
		Student student;
		try {
			Criteria criteria = getActiveSession().createCriteria(Student.class);
			criteria.add(Restrictions.eq("name", name));
			System.out.println("find by name : "+ name);
			student = (Student) criteria.uniqueResult();
		} catch (HibernateException e) {
			rollbackTransaction();
			throw new Exception("Error fetching the user: " + name, e);
		}
		return student;

	}
	
	@Override
	public Student findStudentByEmail(String email) throws Exception {
		Student student;
		try {
			Criteria criteria = getActiveSession().createCriteria(Student.class);
			criteria.add(Restrictions.eq("email", email));
			student = (Student) criteria.uniqueResult();
		} catch (HibernateException e) {
			rollbackTransaction();
			throw new Exception("Error fetching the user: " + email, e);
		}
		return student;

	}

	@Override
	public void deleteStudent(Student student) {
		try {
			beginHibernateTransaction();
	        getActiveSession().delete(student);
	        commitTransaction();
	    } catch (HibernateException e) {
	        rollbackTransaction();
	        throw new RuntimeException("Cannot delete student: " + student.getId(), e);
	    }
	}
}
