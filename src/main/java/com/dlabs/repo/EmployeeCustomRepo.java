package com.dlabs.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dlabs.model.Employee;
import com.dlabs.model.Name;

/**
 * @author Kamlesh Kumar 
 * Date 29-August-2020 
 * This is a EmployeeCustomRepo Interface
 */
@Repository
public interface EmployeeCustomRepo {

	/*
	 * Find List of Employee By Name
	 */
	List<Employee> findByName(Name name);

	/*
	 * Find List of Employee By Name and City
	 */
	List<Employee> findByNameAndCity(Name name, String city);
}
