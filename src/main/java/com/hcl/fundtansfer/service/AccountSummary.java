package com.hcl.fundtansfer.service;

import java.util.List;
import java.util.Optional;

import com.hcl.fundtansfer.entity.Account;
import com.hcl.fundtansfer.utils.ResponseData;

public interface AccountSummary {

	public ResponseData getAccountSummary(Long customerId);

}
