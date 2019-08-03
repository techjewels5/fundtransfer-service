package com.hcl.fundtansfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.fundtansfer.entity.Customer;
import com.hcl.fundtansfer.entity.Payee;

@Repository
public interface PayeeRepository extends JpaRepository<Payee, Long> {

	Payee findByUserId(Customer customer);

	@Query(value = "Select * from fundtransfer.payee p where p.user_id = :customerId ",nativeQuery = true)
	Payee findByUserId(long customerId);
	
	

}
