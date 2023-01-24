package com.userwallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userwallet.model.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer>{

}
