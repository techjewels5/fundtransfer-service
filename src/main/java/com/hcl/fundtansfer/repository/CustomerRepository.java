package com.hcl.fundtansfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.hcl.fundtansfer.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	public Optional<Customer> findByCustomerIdAndPassword(Long customerId, String password);

	Optional<Customer> findByCustomerId(Long customerId);

}
