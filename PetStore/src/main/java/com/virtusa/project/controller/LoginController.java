package com.virtusa.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.project.dto.LoginDto;
import com.virtusa.project.model.UserModel;
import com.virtusa.project.service.LoginService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@PostMapping("/signup")
	public ResponseEntity<Object> signupUser(@RequestBody UserModel user) {
		
		return loginService.signupUser(user);
	}

	@PostMapping("/login")
	public ResponseEntity<Object> loginUser(@RequestBody LoginDto login) {
		return loginService.loginUser(login);
	}

}
