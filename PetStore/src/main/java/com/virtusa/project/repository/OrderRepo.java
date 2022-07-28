package com.virtusa.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.project.model.Order;
import com.virtusa.project.model.UserModel;

@Repository
public interface OrderRepo  extends JpaRepository<Order, Long> {
    List<Order> findAllByUserOrderByCreatedDateDesc(UserModel user);

}