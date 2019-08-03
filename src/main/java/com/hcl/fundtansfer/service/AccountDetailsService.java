package com.hcl.fundtansfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.fundtansfer.repository.AccountRepository;
import com.hcl.fundtansfer.repository.TransactionRepository;
import com.hcl.fundtansfer.utils.ResponseData;

@Service
public class AccountDetailsService {

	@Autowired
	AccountRepository accountRepository;
	
	TransactionRepository transactionRepository;

	public ResponseData getAccountDetails(String customerId) {
		
		
		Account account = accountRepository.findById(customerId);
		Transaction transaction = transactionRepository.findByFromAccount(account.getAccountNumber());
		
		
		ResponseData responseData = new ResponseData();
		responseData.setMessage(null);
		responseData.setHttpStatus(HttpStatus.OK);
		responseData.setData();
		
		return responseData;
	}
	
	
	
}
