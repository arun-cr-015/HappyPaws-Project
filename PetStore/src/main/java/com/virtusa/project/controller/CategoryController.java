package com.virtusa.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.project.exception.CategoryNotExistException;
import com.virtusa.project.model.ProductCategory;
import com.virtusa.project.service.ProductCategoryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
	private ProductCategoryService categoryService;

	public CategoryController(ProductCategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	@PostMapping("/addcategory")
	public ResponseEntity<Object> addCategory(@RequestBody ProductCategory category) {
		return categoryService.addCategory(category);
	}

	@GetMapping("/allcategory")
	public List<ProductCategory> listCategory() {
		return categoryService.listCategory();
	}

	@PostMapping("/editcategory/{cid}")
	public ProductCategory editCategory(@RequestBody ProductCategory category,
			@PathVariable(value = "cid") long categoryId) {
		Optional<ProductCategory> categoryLocal = categoryService.checkCategory(categoryId);
		if (categoryLocal.isEmpty()) {
			throw new CategoryNotExistException("Categoty id is invalid " + categoryId);
		}
		return categoryService.editCategory(category, categoryLocal.get());

	}

	@GetMapping("/getcategory/{categoryId}")
	public Optional<ProductCategory> getCategoryById(@PathVariable(value = "categoryId") long categoryId) {
		return categoryService.checkCategory(categoryId);
	}

	@GetMapping("/deletecategory/{categoryId}")
	public void deleteCategoryById(@PathVariable(value = "categoryId") long categoryId) {
		categoryService.deleteCategory(categoryId);
	}
}
