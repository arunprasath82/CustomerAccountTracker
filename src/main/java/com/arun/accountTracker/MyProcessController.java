package com.arun.accountTracker;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arun.accountTracker.model.Customer;
import com.arun.accountTracker.service.AccountServiceImpl;

@RestController
public class MyProcessController {
	
	@Autowired(required=true)
	AccountServiceImpl accountServiceImpl;
	
	@RequestMapping(path="/fundTransfer")
	ResponseEntity<Customer> fundTransfer(@RequestParam(value="fromAccountId") String fromAccountId, @RequestParam(value="toAccountId")   String toAccountId,@RequestParam(value="amount") String amount){
		
		Customer customer= accountServiceImpl.fundTransfer(Long.valueOf(fromAccountId), Long.valueOf(toAccountId), Long.valueOf(amount));
		return new ResponseEntity<>(customer, HttpStatus.FOUND);
	}

}
