package com.javatechie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	Product findByProductName(String productName);

}
