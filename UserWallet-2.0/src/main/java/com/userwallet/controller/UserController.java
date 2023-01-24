package com.userwallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.userwallet.model.Transaction;
import com.userwallet.model.User;
import com.userwallet.service.TranscationService;
import com.userwallet.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TranscationService transcationService;
	
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		
		User save = userService.AddUser(user);
		return new ResponseEntity<User>(save,HttpStatus.CREATED);
	}
	
	@PostMapping("/user/withdraw/{id}/{amount}")
	public ResponseEntity<Integer> withdraw(@PathVariable("id") Integer id, @PathVariable("amount") Integer amount){
		
		Integer withdraw = userService.withdraw(id,amount);
		return new ResponseEntity<Integer>(withdraw,HttpStatus.CREATED);
	}
	
	@PostMapping("/user/deposite/{id}/{amount}")
	public ResponseEntity<Integer> deposite(@PathVariable("id") Integer id, @PathVariable("amount") Integer amount){
		
		Integer deposit = userService.addBalance(id,amount);
		return new ResponseEntity<Integer>(deposit,HttpStatus.CREATED);
	}
	
	@GetMapping("/user/balance/{id}")
    public ResponseEntity<Integer> deposite(@PathVariable("id") Integer id){
		
		Integer amount = userService.getWalletbalanceByUserId(id);
		return new ResponseEntity<Integer>(amount,HttpStatus.CREATED);
	}
	
	@GetMapping("/user/history/{id}")
    public ResponseEntity<List<Transaction>> getHistory(@PathVariable("id") Integer id){
		
		List<Transaction> listTra = transcationService.getTransaction(id);
		
		return new ResponseEntity<List<Transaction>>(listTra,HttpStatus.CREATED);
	}

}
