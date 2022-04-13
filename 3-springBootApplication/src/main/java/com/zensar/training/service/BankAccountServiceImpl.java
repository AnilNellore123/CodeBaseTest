package com.zensar.training.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.zensar.training.bean.LoginUser;
import com.zensar.training.db.LoginUserDAO;


@Service
public class BankAccountServiceImpl implements BankAccountService{

	
	
	
	@Autowired
BankAccountDAO loginUserDAO;

	public BankAccount addLoginUser(BankAccountUser BankAccountr) {
		return this.BankAccountDAO.save(BankAccount);
	}


	public BankAccount findLoginUserByName(String name) {
		return this.BankAccountDAO.findByName(name);
	}


	@Override
	public BankAccountDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		BankAccount loginUser=findBankAccountByName(username);
		BankAccount user=new User(BankAccount.getName),BankAccount.getPassword(), new ArrayList());
		return user;
	}

	}

