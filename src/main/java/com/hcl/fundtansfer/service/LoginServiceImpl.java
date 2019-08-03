package com.hcl.fundtansfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.CustomRepositoryImplementationDetector;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.hcl.fundtansfer.dto.LoginDto;
import com.hcl.fundtansfer.entity.Customer;
import com.hcl.fundtansfer.repository.CustomerRepository;
import com.hcl.fundtansfer.utils.ResponseData;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CustomerRepository customerRepository;

	public ResponseData login(Long customerId, String password) {
		ResponseData response = new ResponseData();

		if (customerId == 0 || password == null) {

			response.setData(null);
			response.setHttpStatus(HttpStatus.NOT_FOUND);
			response.setMessage("Invalid UserId and Password");

		}

		Optional<Customer> customer = customerRepository.findByCustomerIdAndPassword(customerId, password);
		System.out.println(customer);
		if (customer.isPresent()) {

			response.setData(customer);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Login Successful");

		} else {
			response.setMessage("Invalid UserId and Password");
		}
		return response;

	}

}
