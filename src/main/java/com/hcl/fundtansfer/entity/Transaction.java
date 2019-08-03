package com.hcl.fundtansfer.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;

	private LocalDate transactionDate;

	private String transactionType;

	private Double amount;

	private Long toAccount;

	private String comment;
	
	@ManyToOne
	@JoinColumn(name = "accountNumber")
	@JsonIgnore
	private Account fromAccount;
}
