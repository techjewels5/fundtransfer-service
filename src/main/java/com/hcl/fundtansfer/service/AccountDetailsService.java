package com.hcl.fundtansfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.hcl.fundtansfer.dto.AccountDetailsDto;
import com.hcl.fundtansfer.dto.TransactionHistoryDto;
import com.hcl.fundtansfer.entity.Account;
import com.hcl.fundtansfer.entity.Transaction;
import com.hcl.fundtansfer.exception.ResourceNotFoundException;
import com.hcl.fundtansfer.repository.AccountRepository;
import com.hcl.fundtansfer.repository.TransactionRepository;
import com.hcl.fundtansfer.utils.ResponseData;

@Service
public class AccountDetailsService {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;

	public ResponseData getAccountDetails(Long customerId) {
		
		Optional<Transaction> transaction = null;
		ResponseData responseData = new ResponseData();
		
		Optional<Account> account = accountRepository.findByUserId(customerId);
		System.out.println(customerId);
		System.out.println(account);
		if(!account.isPresent()) {
			throw new ResourceNotFoundException("Customer Id is not valid: " + customerId);
		}
		
		transaction = transactionRepository.findByFromAccount(account.get().getAccountNumber());
		System.out.println(transaction);
		if(!account.isPresent()) {
			throw new ResourceNotFoundException("No transactions Found for customer id:" + customerId);
		}
		
		AccountDetailsDto accountDetailsDto = getAccountDetailsDto(transaction, account);
		
		responseData.setMessage(null);
		responseData.setHttpStatus(HttpStatus.OK);
		responseData.setData(accountDetailsDto);
		
		return responseData;
			
	}

	private AccountDetailsDto getAccountDetailsDto(Optional<Transaction> transaction, Optional<Account> account) {
		TransactionHistoryDto transactionHistroyDto = new TransactionHistoryDto();
		transactionHistroyDto.setAmount(transaction.get().getAmount());
		transactionHistroyDto.setFromAccount(transaction.get().getFromAccount().getAccountNumber());
		transactionHistroyDto.setToAccount(transaction.get().getToAccount());
		transactionHistroyDto.setTransactionDate(transaction.get().getTransactionDate());
		transactionHistroyDto.setTransactionType(transaction.get().getTransactionType());
		
		AccountDetailsDto accountDetailsDto = new AccountDetailsDto();
		accountDetailsDto.setAccountBalance(account.get().getBalance());
		accountDetailsDto.setAccountCreationDate(account.get().getCreationDate());
		accountDetailsDto.setAccountNumber(account.get().getAccountNumber());
		
		accountDetailsDto.setTransactionHistroy(transactionHistroyDto);
		return accountDetailsDto;
	}
	
}
