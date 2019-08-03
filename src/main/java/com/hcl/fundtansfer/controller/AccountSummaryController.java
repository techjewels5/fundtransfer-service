package com.hcl.fundtansfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.fundtansfer.service.AccountSummary;
import com.hcl.fundtansfer.utils.ResponseData;

@RestController
@CrossOrigin
@RequestMapping("/account")
public class AccountSummaryController {

	@Autowired
	AccountSummary accountSummary;

	@GetMapping("/{customerDetails}")
	public ResponseEntity<Object> getAccountSummary(@PathVariable("customerDetails") Long customerDetails) {
		ResponseData responseData=accountSummary.getAccountSummary(customerDetails);
		return new ResponseEntity<Object>(responseData, responseData.getHttpStatus());
	}
}
