package com.hcl.fundtansfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.fundtansfer.dto.AccountDetailsDto;
import com.hcl.fundtansfer.entity.Account;
import com.hcl.fundtansfer.entity.Transaction;
import com.hcl.fundtansfer.repository.AccountRepository;
import com.hcl.fundtansfer.repository.TransactionRepository;
import com.hcl.fundtansfer.utils.ResponseData;

@Service
public class AccountDetailsService {

	@Autowired
	AccountRepository accountRepository;
	
	TransactionRepository transactionRepository;

	public ResponseData getAccountDetails(Long customerId) {
		
		
		Account account = accountRepository.findByAccountNumber(customerId);
		Transaction transaction = transactionRepository.findByFromAccount(account.getAccountNumber());
		
		AccountDetailsDto accountDetailsDto = new AccountDetailsDto();
		accountDetailsDto.setAccountBalance(account.getBalance());
		accountDetailsDto.setAccountCreationDate(account.getCreationDate());
		accountDetailsDto.setAccountNumber(account.getAccountNumber());
		//accountDetailsDto.setTransactionHistroy(transaction);
		
		ResponseData responseData = new ResponseData();
		responseData.setMessage(null);
		responseData.setHttpStatus(HttpStatus.OK);
		responseData.setData(null);
		
		return responseData;
	}
	
	
	
}
