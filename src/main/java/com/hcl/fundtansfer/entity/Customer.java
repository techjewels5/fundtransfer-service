package com.hcl.fundtansfer.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	
	@NotNull
	@NotBlank
	private String password;
	
	@NotNull
	@NotBlank
	private String fullName;
	
	@NotNull
	private String mobileNumber;
	
	@NotNull
	@NotBlank
	private String email;
	
	@NotNull
	@NotBlank
	private String gender;
	
	@NotNull
	private LocalDate dob;
	
	@OneToOne(mappedBy = "customerDetails")
	private Account account;
}
