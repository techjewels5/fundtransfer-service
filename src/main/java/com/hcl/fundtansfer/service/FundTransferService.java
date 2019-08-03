package com.hcl.fundtansfer.service;

import com.hcl.fundtansfer.dto.FundTransferDto;
import com.hcl.fundtansfer.utils.ResponseData;

public interface FundTransferService {

	public ResponseData fundTransfer(FundTransferDto fundTransferDto);
}
