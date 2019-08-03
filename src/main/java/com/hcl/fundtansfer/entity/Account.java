package com.hcl.fundtansfer.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class)
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long accountNumber;

	private Double balance;

	private String accountType;
	
	private String accountHolder;
	
	private LocalDate creationDate;
	
	private Double minmumBalance;
	
	private Double transectionLimit;
	
	private double todaysTransectionLimit;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private Customer customerDetails;
	
	@OneToMany(mappedBy = "fromAccount")
	private List<Transaction> transactionHistories;

}
