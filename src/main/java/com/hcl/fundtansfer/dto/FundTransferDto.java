package com.hcl.fundtansfer.dto;

import lombok.Data;

@Data
public class FundTransferDto {

	private Long fromAccount;
	
	private Long toAccount;
	
	private Double amount;
	
	private String comment;
}
