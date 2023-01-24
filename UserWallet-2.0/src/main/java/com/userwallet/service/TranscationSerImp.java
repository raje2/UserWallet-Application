package com.userwallet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userwallet.model.Transaction;
import com.userwallet.model.User;
import com.userwallet.repository.TransactionRepo;
import com.userwallet.repository.UserRepo;

@Service
public class TranscationSerImp implements TranscationService{
	
	@Autowired
	private TransactionRepo transactionRepo;
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public Transaction addTransaction(Transaction transaction) {
		return transactionRepo.save(transaction);
	}

	@Override
	public List<Transaction> getTransaction(Integer id) {
		
		Optional<User> findUser = userRepo.findById(id);
		
		List<Transaction> findtra = findUser.get().getTransactions();
		
		
		return findtra;
	}

}
