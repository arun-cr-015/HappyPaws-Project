package com.virtusa.project.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.project.model.UserModel;
import com.virtusa.project.model.WishList;

@Repository
public interface WishListRepo extends JpaRepository<WishList, Long> {
  public Optional<WishList> findByUser(UserModel user);
    
    

}
