package com.userwallet.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Data
@Table(name = "users")
public class User {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer id;
		
		@NotEmpty
		@Column(nullable = false)
		private String firstName;
		
		private String lastName;
		
		private Integer wallet;
		
		@Column(nullable = false, unique = true)
		@Email
		private String email;
		
		private String password;
		
		@JsonIgnore
		@OneToMany(cascade = CascadeType.MERGE)
		@JoinTable(name = "user_trans" ,
		           joinColumns = {@JoinColumn(name = "user_id", referencedColumnName ="ID" ) },
		           inverseJoinColumns = {@JoinColumn(name = "trans_id", referencedColumnName = "ID")}
		                )
		private List<Transaction> transactions;

		public User(User user) {
			
			this.firstName = user.getFirstName();
			this.lastName = user.getLastName();
			this.wallet = user.getWallet();
			this.email = user.getEmail();
			this.password = user.getPassword();
		}
		
	   public User() {
			
		}
		

}
