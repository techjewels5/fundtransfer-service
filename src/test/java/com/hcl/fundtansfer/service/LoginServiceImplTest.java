 package com.hcl.fundtansfer.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.util.Experimental;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.common.base.Optional;
import com.hcl.fundtansfer.dto.LoginDto;
import com.hcl.fundtansfer.entity.Customer;
import com.hcl.fundtansfer.exception.ResourceNotFoundException;
import com.hcl.fundtansfer.repository.CustomerRepository;
import com.hcl.fundtansfer.utils.ResponseData;

@RunWith(MockitoJUnitRunner.class) 
 public class LoginServiceImplTest {
 
 Customer customer;
 LoginDto dto;
 
 @Mock
 CustomerRepository customerRepository;
 
 @InjectMocks
 private LoginServiceImpl loginServiceImpl;
 
 
 @org.junit.Before
 public void setUp() throws Exception {
 
 String message = "Login Successful";  customer = new Customer();
 
 customer.setPassword("pass"); customer.setCustomerId(1l);
 
 dto = new LoginDto(); dto.setPassword("pass"); dto.setCustomerId(1l);
 
 }
 
 @Test public void testLoginUseSuccessSenario() {
 
 Mockito.when(customerRepository.findByCustomerIdAndPassword(1L,"pass")).thenReturn(Optional.of(customer)); 
 ResponseData response =loginServiceImpl.login(customer.getCustomerId(), customer.getPassword());
 assertEquals("Login Successful", response.getMessage());
 assertNotNull(response);
 
 }
 
 
 @Test(expected = ResourceNotFoundException.class)
 public void testLoginUserFaildSenario() {
	 
	 Mockito.when(customerRepository.findByCustomerIdAndPassword(1L,null)).thenThrow(ResourceNotFoundException.class); 
	 loginServiceImpl.login(customer.getCustomerId(), null);
	 
	 }
 
 }
 