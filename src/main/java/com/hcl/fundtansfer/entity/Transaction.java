package com.hcl.fundtansfer.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class)
public class Transaction implements Serializable {

	private static final long serialVersionUID = -4889888447857772531L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;

	private LocalDate transactionDate;

	private String transactionType;

	private Double amount;

	private Long toAccount;
	
	private Long fromAccount;

	private String comment;
	
	@ManyToOne
	@JoinColumn(name = "account_number")
	@JsonIgnore
	private Account accountNumber;
}
