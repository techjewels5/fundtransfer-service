package com.hcl.fundtansfer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Payee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long payeeTrackId;
	
	@ManyToOne
	@JoinColumn(name = "payee_id")
	private Customer payeeId;

	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Customer userId;
}
