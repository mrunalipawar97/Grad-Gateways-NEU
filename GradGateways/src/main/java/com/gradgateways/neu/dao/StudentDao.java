package com.gradgateways.neu.dao;

import java.util.List;
import com.gradgateways.neu.model.Student;

/**
*
* @author mrunalipawar
* interface : StudentDao
*/

public interface StudentDao {

	List<Student> findAll();

	void saveStudent(Student student) throws Exception;

	Student findStudentByName(String name) throws Exception;

	Student findStudentByEmail(String email) throws Exception;

	void deleteStudent(Student student);
}
