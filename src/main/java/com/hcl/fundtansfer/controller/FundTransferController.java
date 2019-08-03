package com.hcl.fundtansfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.fundtansfer.dto.FundTransferDto;
import com.hcl.fundtansfer.service.FundTransferService;
import com.hcl.fundtansfer.utils.ResponseData;

@RestController
@RequestMapping("/account")
public class FundTransferController {

	@Autowired
	private FundTransferService fundTransferServiceImpl;
	
	@PostMapping("/transfer")
	public ResponseEntity<Object> fundTransfer(FundTransferDto fundTransferDto){
		ResponseData response = fundTransferServiceImpl.fundTransfer(fundTransferDto);
		return new ResponseEntity<>(response,response.getHttpStatus());
		
	}
}
