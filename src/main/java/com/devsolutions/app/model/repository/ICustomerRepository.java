package com.devsolutions.app.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.devsolutions.app.model.Customer;

public interface ICustomerRepository extends MongoRepository<Customer, String> {

	@Query("{name:'?0'}")
	Customer findItemByName(String name);
	
	@Query(value="{noCuenta:'?0'}", fields="{'id' : 1, 'nombre' : 1}")
	List<Customer> findAllAccount(Long noCuenta);
	
	public long count();
	
}
