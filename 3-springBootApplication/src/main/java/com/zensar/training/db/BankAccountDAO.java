package com.zensar.training.db;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.training.bean.BankAccount;

public class BankAccountDAO extends JpaRepository<LoginUser,Integer>{

		BankAccount findByName(String name);


	}

