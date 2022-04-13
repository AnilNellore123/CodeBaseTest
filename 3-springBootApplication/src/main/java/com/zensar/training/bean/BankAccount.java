package com.zensar.training.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement
@Table(name = "BankAccount20")
public class BankAccount {
	@Id
	@GeneratedValue
	int accountNo;
	String name;
	double balance;


	public BankAccount() {
	super();
	// TODO Auto-generated constructor stub
	}




	public BankAccount(int accountNo, String name, double balance) {
	super();
	this.accountNo = accountNo;
	this.name = name;
	this.balance = balance;
	}




	public int getAccountNo() {
	return accountNo;
	}



	public void setAccountNo(int accountNo) {
	this.accountNo = accountNo;
	}




	public String getName() {
	return name;
	}




	public void setName(String name) {
	this.name = name;
	}




	public double getBalance() {
	return balance;
	}




	public void setBalance(double balance) {
	this.balance = balance;
	}




	@Override
	public String toString() {
	return "Person [accountNo=" + accountNo + ", name=" + name + ", balance=" + balance + "]";
	}


	}


