package com.gradgateways.neu.dao;

import java.util.List;
import com.gradgateways.neu.model.Employer;

/**
*
* @author mrunalipawar
* interface : EmployerDao
*/
public interface EmployerDao {

	List<Employer> findAllEmployers();
    void saveEmployer(Employer employer) throws Exception; 
    Employer findEmployerByEmail(String email) throws Exception;
    void deleteEmployer(Employer employer);
    void updateEmployer(Employer employer) throws Exception;

}
