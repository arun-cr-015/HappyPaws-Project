package com.virtusa.project.responseentity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.virtusa.project.exception.CartItemNotExistException;
import com.virtusa.project.exception.CartNotExistException;
import com.virtusa.project.exception.CategoryNotExistException;
import com.virtusa.project.exception.OrderNotExistException;
import com.virtusa.project.exception.ProductNotExistException;
import com.virtusa.project.exception.ReviewNotExistException;
import com.virtusa.project.exception.UserNotExistException;
import com.virtusa.project.exception.WishListItemNotExistException;
import com.virtusa.project.exception.WishListNotExistException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = ProductNotExistException.class)
	public ResponseEntity<Object> exception(ProductNotExistException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(value = UserNotExistException.class)
	public ResponseEntity<Object> exception(UserNotExistException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(value = CategoryNotExistException.class)
	public ResponseEntity<Object> exception(CategoryNotExistException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(value = CartNotExistException.class)
	public ResponseEntity<Object> exception(CartNotExistException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(value = OrderNotExistException.class)
	public ResponseEntity<Object> exception(OrderNotExistException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(value = ReviewNotExistException.class)
	public ResponseEntity<Object> exception(ReviewNotExistException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
	}
	@ExceptionHandler(value = CartItemNotExistException.class)
	public ResponseEntity<Object> exception(CartItemNotExistException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
	}
	@ExceptionHandler(value = WishListItemNotExistException.class)
	public ResponseEntity<Object> exception(WishListItemNotExistException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
	}
	@ExceptionHandler(value = WishListNotExistException.class)
	public ResponseEntity<Object> exception(WishListNotExistException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
	}
}
