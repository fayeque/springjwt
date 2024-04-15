package com.javatechie.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javatechie.entity.ShopkeeperResponse;

public interface ShopkeeperResponseRepository extends JpaRepository<ShopkeeperResponse, Integer> {
	

//	ArrayList<ShopkeeperResponse> findByProductIdAndIsAvailableAndStockGreaterThan(int id, boolean availability,
//			int stock);

	@Query("SELECT u FROM User u WHERE u.username = :username AND u.email = :email")
	ArrayList<ShopkeeperResponse> existingResponse(@Param("product_id") String productId);
		
}
