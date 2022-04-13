package com.zensar.training.bean;

public class BankAccountResponse {
	
		String jwt;

		public  BankAccountResponse(String jwt) {
			super();
			this.jwt = jwt;
		}

		public  BankAccountResponse() {
			super();
			// TODO Auto-generated constructor stub
		}

		public String getJwt() {
			return jwt;
		}

		public void setJwt(String jwt) {
			this.jwt = jwt;
		}

		@Override
		public String toString() {
			return " BankAccountResponse [jwt=" + jwt + "]";
		}
		
		
	}



