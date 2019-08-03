package com.hcl.fundtansfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.fundtansfer.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	
	//Optional<Account> findByCustomerDetails(Customer customer);
	
	@Query(value = "Select * from fundtransfer.account a where a.user_id = :customerId", nativeQuery = true)
	Account findByCustomerAccount(Long customerId);

	// findByCustomerDto(Long customerId);

}
