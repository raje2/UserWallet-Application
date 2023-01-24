package com.userwallet.service;

import com.userwallet.model.User;

public interface UserService {
	
	public User AddUser(User user);
	
	public Integer getWalletbalanceByUserId(Integer id);
	
	public Integer withdraw(Integer id,Integer amount);
	
	public Integer addBalance(Integer id,Integer amount);
	
	public User findByid(Integer id);

}
