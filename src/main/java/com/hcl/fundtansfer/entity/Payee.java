package com.hcl.fundtansfer.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class)
public class Payee implements Serializable {

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
