package com.zensar.training.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.training.Security.util.JwtUtil;
import com.zensar.training.bean.LoginRequest;
import com.zensar.training.bean.LoginResponse;
import com.zensar.training.bean.LoginUser;
import com.zensar.training.service.LoginServiceImpl;

@RestController
public class BankAccountController {

	
		
		@Autowired
		BankAccountServiceImpl loginServiceImpl;
		
		@Autowired
	    JwtUtil jwtUtil;
		
		@Autowired
		AuthenticationManager authenticationManager;
		
		@PostMapping("/addUser")
		public LoginUser add(@RequestBody LoginUser loginUser) {
			return this.BankAccountServiceImpl.addLoginUser(loginUser);
		}

		@GetMapping("/findUser/{name}")
			public LoginUser finLoginUserByName(@PathVariable(name = "name") String name) {
			return this.BankAccountServiceImpl.findBankAccountByName(name);
		}
		
		@PostMapping("/authenticate")
		public BankAccountResponse createToken(@RequestBody BankAccountRequest BankAccountRequest) {
			UsernamePasswordAuthenticationToken authUserPass;
			authUserPass=new UsernamePasswordAuthenticationToken(BankAccountRequest.getUserName(), BankAccountRequest.getPassword());
			this.authenticationManager.authenticate(authUserPass);
			
			UserDetails userDetails;
			userDetails=BankAccountServiceImpl.loadUserByUsername(BankAccountRequest.getUserName());
			
			String jwtStr= jwtUtil.generateToken(BankAccountRequest.getUserName());
			
			return new BankAccountResponse(jwtStr);
		}
	}

