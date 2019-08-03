package com.hcl.fundtansfer.service;

import com.hcl.fundtansfer.utils.ResponseData;

public interface LoginService {
	
	
	public ResponseData login(Long customerId, String password);

}
