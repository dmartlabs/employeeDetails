package com.dlabs.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dlabs.model.Employee;

/**
 * @author Kamlesh Kumar
 * Date 26-August-2020
 * This is a EmployeeRepository Interface
 */
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>,EmployeeCustomRepo {

}
