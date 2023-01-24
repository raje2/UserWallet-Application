package com.userwallet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userwallet.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	Optional<User> findUserByEmail(String email);

}
