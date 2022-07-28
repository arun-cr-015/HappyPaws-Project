package com.virtusa.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.project.model.Product;
import com.virtusa.project.model.Review;

public interface ReviewRepo extends JpaRepository<Review, Long>{
	List<Review> findAllByProduct(Product product);
}
