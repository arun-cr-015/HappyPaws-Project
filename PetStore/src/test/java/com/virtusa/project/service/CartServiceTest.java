package com.virtusa.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.virtusa.project.dto.AddtoCart;
import com.virtusa.project.model.Cart;
import com.virtusa.project.model.Product;
import com.virtusa.project.model.UserModel;

@RunWith(SpringRunner.class)
@SpringBootTest
class CartServiceTest {
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;

	@Test
	void addtoCartFirstTimeTest() {
		Product product = productService.getOneProduct(1);
		AddtoCart addCart = new AddtoCart();
		addCart.setQuantity(2);
		UserModel user = userService.getOneUser((long) 1);
		Cart cart = cartService.addtoCartFirstTime(addCart, product, user);
		assertEquals("Labrador", cart.getItems().stream().findFirst().get().getProduct().getProductName());

	}

	@Test
	void getCartByUserTest() {
		long id = 1;
		Cart cart = cartService.getCartByUser(id);
		assertEquals("Arun", cart.getUser().getName());

	}
	
}
