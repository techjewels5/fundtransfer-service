package com.hcl.fundtansfer.dto;

import lombok.Data;

@Data
public class AccountDto {

	private Long accountNumber;
	private Double balance;
	private String accountType;
	private String accountHolder;
	
}
