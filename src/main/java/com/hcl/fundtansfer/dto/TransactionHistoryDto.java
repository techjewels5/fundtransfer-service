package com.hcl.fundtansfer.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TransactionHistoryDto {

	Long s_no;
	Long fromAccount;
	Long toAccount;
	Double amount;
	LocalDate transactionDate;
	String transactionType;

}
