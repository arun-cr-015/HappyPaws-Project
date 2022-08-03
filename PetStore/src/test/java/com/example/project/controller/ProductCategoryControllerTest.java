package com.example.project.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.project.model.ProductCategory;
import com.example.project.service.ProductCategoryService;

@SpringBootTest(classes = { ProductCategoryControllerTest.class })
class ProductCategoryControllerTest {

	@Mock
	ProductCategoryService categoryService;
	@InjectMocks
	CategoryController categoryController;

	public List<ProductCategory> categorys;

	@Test
	void allcategory() {
		categorys = new ArrayList<ProductCategory>();
		categorys.add(new ProductCategory(1, "Birds", "Some Url"));
		categorys.add(new ProductCategory(2, "Dogs", "Some Url"));
		when(categoryService.listCategory()).thenReturn(categorys);
		assertEquals(2, categoryController.listCategory().size());
	}

	@Test
	void addCategoryTest() {
		ProductCategory category = new ProductCategory(1, "Birds", "Some Url");
		ResponseEntity<Object> resp = new ResponseEntity<>(category, HttpStatus.OK);
		when(categoryService.addCategory(category)).thenReturn(resp);
		assertEquals(HttpStatus.OK, categoryController.addCategory(category).getStatusCode());
	}

	@Test
	void editCategoryTest() {
		long categoryId = 1;
		Optional<ProductCategory> categoryExist = Optional.ofNullable(new ProductCategory(1, "Birds", "Some Url"));
		ProductCategory category = new ProductCategory(1, "Bird", "Some Url");
		when(categoryService.checkCategory(1)).thenReturn(categoryExist);
		when(categoryService.editCategory(category, categoryExist.get())).thenReturn(category);
		assertEquals(category.getCategoryName(),
				categoryController.editCategory(category, categoryId).getCategoryName());
	}

	@Test
	void getCategoryTest() {
		long categoryId = 1;
		Optional<ProductCategory> categoryExist = Optional.ofNullable(new ProductCategory(1, "Birds", "Some Url"));
		when(categoryService.checkCategory(1)).thenReturn(categoryExist);
		assertEquals(categoryExist.get().getCategoryName(),
				categoryController.getCategoryById(categoryId).get().getCategoryName());
	}

}
