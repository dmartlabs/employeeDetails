package com.dlabs.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dlabs.model.Employee;
import com.dlabs.model.Name;

/**
 * @author Kamlesh Kumar 
 * Date 29-August-2020 
 * This is a EmployeeCustomRepoImpl class
 */

@Repository
public class EmployeeCustomRepoImpl implements EmployeeCustomRepo {

	@Autowired
	MongoTemplate mongoTemplate;

	/***
	 * Find List of Employee By Name
	 * @param name
	 * @return List<Employee>
	 */
	@Override
	public List<Employee> findByName(Name name) {
		Query query = new Query(Criteria.where("name.firstName").is(name.getFirstName())
				.andOperator(Criteria.where("name.lastName").is(name.getLastName())));
		return mongoTemplate.find(query, Employee.class);

	}

	/***
	 * Find List of Employee By Name and City
	 * @param name,city
	 * @return List<Employee>
	 */
	@Override
	public List<Employee> findByNameAndCity(Name name, String city) {
		Query query = new Query(Criteria.where("name.firstName").is(name.getFirstName()));
		query.addCriteria(Criteria.where("name.lastName").is(name.getLastName()));
		query.addCriteria(Criteria.where("address.city").is(city));

		return mongoTemplate.find(query, Employee.class);
	}

}
