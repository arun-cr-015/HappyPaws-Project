package com.virtusa.project.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.project.model.WishListItem;

@Repository
public interface WishListItemRepo extends JpaRepository<WishListItem, Long>{

}
