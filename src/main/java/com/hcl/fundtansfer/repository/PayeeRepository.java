package com.hcl.fundtansfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.fundtansfer.entity.Payee;

@Repository
public interface PayeeRepository extends JpaRepository<Payee, Long> {

}
