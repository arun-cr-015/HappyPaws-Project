package com.virtusa.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.project.model.OrderItem;

@Repository
public interface OrderItemsRepo extends JpaRepository<OrderItem,Integer> {
	
}