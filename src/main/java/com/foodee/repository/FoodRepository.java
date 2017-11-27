package com.foodee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodee.dto.FoodItems;

@Repository
public interface FoodRepository extends JpaRepository<FoodItems, Long> {
	
	
	FoodItems findById(int id);


}
