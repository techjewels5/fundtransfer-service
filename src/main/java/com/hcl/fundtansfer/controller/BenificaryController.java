package com.hcl.fundtansfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.fundtansfer.service.PayeeService;
import com.hcl.fundtansfer.utils.ResponseData;

@RestController
@CrossOrigin
@RequestMapping("/benificary")
public class BenificaryController {

	@Autowired
	PayeeService payeeService;
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Object> getBenificaryDetails(@PathVariable("customerId") Long customerId) {
		ResponseData responseData = payeeService.getBenificaryDetails(customerId);
		return new ResponseEntity<Object>(responseData, responseData.getHttpStatus());
		
	}
}
