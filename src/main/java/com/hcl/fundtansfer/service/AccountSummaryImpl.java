package com.hcl.fundtansfer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.fundtansfer.dto.AccountDto;
import com.hcl.fundtansfer.entity.Account;
import com.hcl.fundtansfer.entity.Customer;
import com.hcl.fundtansfer.repository.AccountRepository;
import com.hcl.fundtansfer.repository.CustomerRepository;
import com.hcl.fundtansfer.utils.ResponseData;

@Service
public class AccountSummaryImpl implements AccountSummary {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public ResponseData getAccountSummary(Long customerId) {
		ResponseData responseData = new ResponseData();
		Optional<Customer> cuOptional = customerRepository.findById(customerId);
		if (cuOptional.isPresent()) {
			//Optional<Account> accOptional = accountRepository.findByCustomerDetails(cuOptional.get());
			Account account = accountRepository.findByCustomerAccount(customerId);
			//responseData.setData(accOptional.get());
			
//			AccountDto accountDto = accountRepository.findByCustomerDetails(customerId);
			AccountDto accountDto = new AccountDto();
			accountDto.setAccountHolder(account.getAccountHolder());
			accountDto.setAccountNumber(account.getAccountNumber());
			accountDto.setAccountType(account.getAccountType());
			accountDto.setBalance(account.getBalance());
			
			responseData.setData(accountDto);
			responseData.setHttpStatus(HttpStatus.OK);
		}else {
			responseData.setHttpStatus(HttpStatus.BAD_REQUEST);
			responseData.setMessage("User is Not Present..Please Register first");
		}

		return responseData;

	}

}
