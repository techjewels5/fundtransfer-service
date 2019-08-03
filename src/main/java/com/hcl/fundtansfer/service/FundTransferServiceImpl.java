package com.hcl.fundtansfer.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.fundtansfer.dto.FundTransferDto;
import com.hcl.fundtansfer.entity.Account;
import com.hcl.fundtansfer.entity.Transaction;
import com.hcl.fundtansfer.repository.AccountRepository;
import com.hcl.fundtansfer.repository.TransactionRepository;
import com.hcl.fundtansfer.utils.ResponseData;

@Service
public class FundTransferServiceImpl implements FundTransferService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	// @Transactional
	@Override
	public ResponseData fundTransfer(FundTransferDto fundTransferDto) {

		Optional<Account> fromAccountOptional = accountRepository.findById(fundTransferDto.getFromAccount());
		Optional<Account> toAccountOptional = accountRepository.findById(fundTransferDto.getFromAccount());
		ResponseData response = new ResponseData();

		if (fromAccountOptional.isPresent() && toAccountOptional.isPresent()) {
			Account fromAccount = fromAccountOptional.get();
			Account toAccount = toAccountOptional.get();

			boolean validateMinimumBalance = validateMinimumBalance(fundTransferDto.getAmount(),
					fromAccount.getMinmumBalance(), fromAccount.getBalance());
			boolean validateTransectionLimit = validateTransectionLimit(fundTransferDto.getAmount(),
					fromAccount.getTodaysTransectionLimit());

			if (!validateMinimumBalance) {
				response.setMessage("Insufficient Balance");
				response.setHttpStatus(HttpStatus.OK);
				return response;
			}
			if (!validateTransectionLimit) {
				response.setMessage("Exceeded Daily Transection Limit");
				response.setHttpStatus(HttpStatus.OK);
				return response;
			}
			return updateTransactions(fundTransferDto, response, fromAccount, toAccount);

		}
		response.setMessage("Invalid Account Numbers");
		response.setHttpStatus(HttpStatus.OK);
		return response;
	}

	private ResponseData updateTransactions(FundTransferDto fundTransferDto, ResponseData response, Account fromAccount,
			Account toAccount) {
		fromAccount.setBalance(fromAccount.getBalance() - fundTransferDto.getAmount());
		fromAccount.setTodaysTransectionLimit(fromAccount.getTodaysTransectionLimit() - fundTransferDto.getAmount());
		toAccount.setBalance(toAccount.getBalance() + fundTransferDto.getAmount());
		fromAccount = accountRepository.save(fromAccount);
		toAccount = accountRepository.save(toAccount);
		Transaction debitTransaction = new Transaction();
		Transaction creditTransaction = new Transaction();

		debitTransaction.setAmount(fundTransferDto.getAmount());
		debitTransaction.setComment(fundTransferDto.getComment());
		debitTransaction.setFromAccount(fromAccount.getAccountNumber());
		debitTransaction.setToAccount(fundTransferDto.getToAccount());
		debitTransaction.setTransactionDate(LocalDate.now());
		debitTransaction.setTransactionType("DEBIT");
		debitTransaction.setAccountNumber(fromAccount);

		creditTransaction.setAmount(fundTransferDto.getAmount());
		creditTransaction.setComment(fundTransferDto.getComment());
		creditTransaction.setFromAccount(fromAccount.getAccountNumber());
		creditTransaction.setToAccount(toAccount.getAccountNumber());
		creditTransaction.setTransactionDate(LocalDate.now());
		creditTransaction.setTransactionType("CREDIT");
		debitTransaction.setAccountNumber(toAccount);
		transactionRepository.save(creditTransaction);
		transactionRepository.save(debitTransaction);

		response.setMessage("Transection SuccessFul");
		response.setHttpStatus(HttpStatus.OK);
		return response;
	}

	private boolean validateMinimumBalance(double amount, double minimumBalance, double availabeBalance) {
		if ((availabeBalance - amount) > minimumBalance) {
			return true;
		}
		return false;
	}

	private boolean validateTransectionLimit(double amount, double todaysLimitLift) {

		if (todaysLimitLift > amount) {
			return true;
		}
		return false;
	}

}
