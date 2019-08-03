package com.hcl.fundtansfer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.fundtansfer.dto.PayeeDto;
import com.hcl.fundtansfer.entity.Customer;
import com.hcl.fundtansfer.entity.Payee;
import com.hcl.fundtansfer.repository.CustomerRepository;
import com.hcl.fundtansfer.repository.PayeeRepository;
import com.hcl.fundtansfer.utils.ResponseData;

@Service
public class PayeeServiceImpl implements PayeeService {

	@Autowired
	PayeeRepository payeeRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public ResponseData getBenificaryDetails(Long customerId) {
		PayeeDto payeeDto = new PayeeDto();
		ResponseData responseData = new ResponseData();
		Optional<Customer> cuOptional = customerRepository.findById(customerId);
		if (cuOptional.isPresent()) {
			Payee payee = payeeRepository.findByUserId(cuOptional.get());
	//		Payee payee1 = payeeRepository.findByUserId(cuOptional.get().getCustomerId());
			responseData.setData(payee);
			responseData.setHttpStatus(HttpStatus.OK);
		} else {
			responseData.setHttpStatus(HttpStatus.BAD_REQUEST);
			responseData.setMessage("Customer is Not Present");
		}
		return responseData;
	}

}
