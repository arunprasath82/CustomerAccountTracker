package com.arun.accountTracker.respository;

import org.springframework.data.repository.CrudRepository;

import com.arun.accountTracker.model.Account;


public interface AccountRepository extends CrudRepository<Account,Long> {

}
