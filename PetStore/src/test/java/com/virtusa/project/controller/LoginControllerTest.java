package com.virtusa.project.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.virtusa.project.dto.AuthResponse;
import com.virtusa.project.dto.LoginDto;
import com.virtusa.project.dto.UserDto;
import com.virtusa.project.model.UserModel;
import com.virtusa.project.service.LoginService;

@SpringBootTest(classes = { LoginControllerTest.class })
class LoginControllerTest {

	@Mock
	LoginService loginService;
	@InjectMocks
	LoginController loginController;
	public UserDto userDto = new UserDto((long) 1, "arun@gmail.com", "encoded password", "Arun", false, "9487550114",
			"User");

	@Test
	void loginTest() {
		LoginDto login = new LoginDto();
		login.setEmail("arun@gmail.com");
		login.setPassword("arun2000");
		AuthResponse response = new AuthResponse(userDto, "token");
		ResponseEntity<Object> resp = new ResponseEntity<Object>(response, HttpStatus.OK);
		when(loginService.loginUser(login)).thenReturn(resp);
		assertEquals(resp.getBody(), loginController.loginUser(login).getBody());
	}

	@Test
	void signupTest() {
		UserModel user = new UserModel(userDto.getId(), userDto.getEmail(), userDto.getPassword(), userDto.getName(),
				userDto.getPhoneNumber(), false, userDto.getRole());
		ResponseEntity<Object> response = new ResponseEntity<Object>(user, HttpStatus.OK);
		when(loginService.signupUser(user)).thenReturn(response);
		assertEquals(response.getBody(), loginController.signupUser(user).getBody());
	}

}
