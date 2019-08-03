package com.hcl.fundtansfer.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.fundtansfer.repository.AccountRepository;
import com.hcl.fundtansfer.repository.CustomerRepository;

@RunWith(MockitoJUnitRunner.class)
public class AccountSummaryImplTest {

	@Mock
	CustomerRepository customRepository;
	
	@Mock
	AccountRepository accountRepository;
	
	@Before
	public void setup() {

	}
	
	
	@Test
	public void getAccountSummary() {
		
	}
}
