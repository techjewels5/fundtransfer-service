package com.hcl.fundtansfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcl.fundtansfer.service.AccountDetailsService;
import com.hcl.fundtansfer.utils.ResponseData;

@Repository
@CrossOrigin
@RequestMapping("/account")
public class AccountDetailsController {

	@Autowired
	AccountDetailsService accountDetailsService;
	
	@GetMapping("/details/{customerId}")
	public ResponseEntity<ResponseData> getAccountDetails(@PathVariable Long customerId) {
		return new ResponseEntity<>(accountDetailsService.getAccountDetails(customerId), HttpStatus.OK);
	}
	
}
