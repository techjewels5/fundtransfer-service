package com.hcl.fundtansfer.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Account {
	
	@Id
	private Long accountNumber;

	private Double balance;

	private String accountType;
	
	private String accountHolder;
	
	private LocalDate creationDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private Customer customerDetails;
	
	@OneToMany(mappedBy = "fromAccount")
	private List<Transaction> transactionHistories;

}
