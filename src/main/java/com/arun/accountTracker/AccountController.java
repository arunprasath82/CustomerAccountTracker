package com.arun.accountTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arun.accountTracker.model.Account;
import com.arun.accountTracker.model.Customer;
import com.arun.accountTracker.service.AccountServiceImpl;


@RestController
public class AccountController {

@Autowired	
AccountServiceImpl accountServiceImpl;
	

	@GetMapping("/accountDeatils/{id}")
	public Account getAccountDetails(@PathVariable Long id) {
		
		return accountServiceImpl.getAccountDetails(id);
	}
	
	@PostMapping(path="/addAccount", consumes= {"application/json"})
	public String addCustomerDetails(@RequestBody Account account) {	
		accountServiceImpl.addAccountDetails(account);
	return "account added sucessfully" ;
	}
	
	@PutMapping(path="/updateAccount",consumes= {"application/json"})
	public Account updateCustomerDetails( @RequestBody Account account) {
		accountServiceImpl.addAccountDetails(account);
	
	return account;
	}
	
	@DeleteMapping("/deleteAccount/{id}")
	public String deleteCustomerDetails(@PathVariable Long id) {
		accountServiceImpl.deleteAccountDetails(id);
	return "account details deleted";
	}
	

}
