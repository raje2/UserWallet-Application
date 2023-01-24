package com.userwallet.service;

import java.util.List;

import com.userwallet.model.Transaction;

public interface TranscationService {
	
	public Transaction addTransaction(Transaction transaction);
	
	public List<Transaction> getTransaction(Integer id);

}
