package com.example.project.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.project.controller.UserController;
import com.example.project.model.UserModel;
import com.example.project.service.UserService;

@SpringBootTest(classes = { UserControllerTest.class })
class UserControllerTest {
	@Mock
	UserService userService;
	@InjectMocks
	UserController userController;
	public UserModel user1 = new UserModel((long) 1, "arun@gmail.com", "encoded password", "Arun", "9487550114", false,
			"User");
	public UserModel user2 = new UserModel((long) 2, "ajay@gmail.com", "encoded password", "Ajay", "9487550114", false,
			"User");

	@Test
	void listAllUsersTest() {
		List<UserModel> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		ResponseEntity<List<UserModel>> response = new ResponseEntity<List<UserModel>>(users, HttpStatus.OK);
		when(userService.listAllUsers()).thenReturn(response);
		assertEquals(2, userController.listAllUsers().getBody().size());
	}

	@Test
	void getUserTest() {
		long userId = 1;
		when(userService.getOneUser(userId)).thenReturn(user1);
		assertEquals(user1, userController.forAdmin((userId)));
	}

	@Test
	void editUserTest() {
		long id = 1;
		ResponseEntity<Object> response = new ResponseEntity<Object>(user1, HttpStatus.OK);
		when(userService.editUser(user1, id)).thenReturn(response);
		assertEquals(user1, userController.editUser(user1, id).getBody());
	}

	@Test
	void deleteUser() {
		long id = 1;
		ResponseEntity<HttpStatus> response = new ResponseEntity<HttpStatus>(HttpStatus.OK);
		when(userService.deleteUser(id)).thenReturn(response);
		assertEquals(HttpStatus.OK, userController.deleteUser(id).getStatusCode());

	}
}
