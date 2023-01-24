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
public class UserSerImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private TransactionRepo transactionRepo;

	@Override
	public User AddUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public Integer getWalletbalanceByUserId(Integer id) {
		Optional<User> findUser = userRepo.findById(id);
		Integer amount = 0;
		
		if(findUser.isPresent()) {
			amount = findUser.get().getWallet();
		}
		
		return amount;
		
	}

	@Override
	public Integer withdraw(Integer id, Integer amount) {
		
		Optional<User> findUser = userRepo.findById(id);
		Integer am = 0;
		
		if(findUser.isPresent()) {
			User find = findUser.get();
			Integer withdraw = findUser.get().getWallet()-amount;
		
			find.setWallet(withdraw);
			
			Transaction transaction = new Transaction();
			transaction.setType("withdraw");
			transaction.setAmount(amount);
			Transaction transaction2 = transactionRepo.save(transaction);
			
			find.getTransactions().add(transaction2);
			
			userRepo.save(find);
			
			
			am = amount;
		}
		return am;
	}

	@Override
	public Integer addBalance(Integer id, Integer amount) {
		Optional<User> findUser = userRepo.findById(id);
		Integer am = 0;
		
		if(findUser.isPresent()) {
			User find = findUser.get();
			Integer deposit = findUser.get().getWallet()+amount;
		
			find.setWallet(deposit);
			
			Transaction transaction = new Transaction();
			transaction.setType("Deposit");
			transaction.setAmount(amount);
			Transaction transaction2 = transactionRepo.save(transaction);
			
			find.getTransactions().add(transaction2);
			
			userRepo.save(find);
			
			am = amount;
		}
		return am;
	}

	@Override
	public User findByid(Integer id) {
		
		return userRepo.findById(id).get();
	}

}
