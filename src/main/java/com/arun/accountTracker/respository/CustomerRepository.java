package com.arun.accountTracker.respository;

import org.springframework.data.repository.CrudRepository;

import com.arun.accountTracker.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Long>{

}
