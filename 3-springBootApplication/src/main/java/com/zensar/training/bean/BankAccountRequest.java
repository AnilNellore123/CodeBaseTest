package com.zensar.training.bean;

public class BankAccountRequest {
	
		String userName;
		String password;
		
		public BankAccountRequest(String userName, String password) {
			super();
			this.userName = userName;
			this.password = password;
		}
		public BankAccountRequest() {
			super();
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Override
		public String toString() {
			return "BankAccountRequest [userName=" + userName + ", password=" + password + "]";
		}
		
		
	}



