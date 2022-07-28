package com.virtusa.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.project.model.CartItem;
@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Long>{

}
