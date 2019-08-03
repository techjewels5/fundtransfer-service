package com.hcl.fundtansfer.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AccountDetailsDto {

	Long accountNumber;
	Double accountBalance;
	LocalDate accountCreationDate;
	TransactionHistoryDto transactionHistroy;
	
}
