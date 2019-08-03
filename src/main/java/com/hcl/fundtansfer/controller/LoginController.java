package com.hcl.fundtansfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.fundtansfer.dto.LoginDto;
import com.hcl.fundtansfer.service.LoginService;


@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginDto loginDto)
	{
		return new ResponseEntity<Object>(loginService.login(loginDto.getCustomerId(), loginDto.getPassword()) ,HttpStatus.OK);
		
	}
	
}

