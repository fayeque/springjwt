package com.javatechie.controller;

import java.util.ArrayList;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.entity.Product;
import com.javatechie.entity.ShopkeeperResponse;
import com.javatechie.config.UserInfoUserDetails;
import com.javatechie.dto.CustomerDetails;
import com.javatechie.dto.customer.CustomerRequest;
import com.javatechie.entity.UserInfo;
import com.javatechie.entity.UserRequest;
import com.javatechie.producers.RabbitMQProducer;
import com.javatechie.repository.ProductRepository;
import com.javatechie.repository.ShopkeeperResponseRepository;
import com.javatechie.repository.UserRequestRepository;

import antlr.collections.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserRequestRepository userRequestRepository;
	
	@Autowired
	ShopkeeperResponseRepository shopkeeperResponseRepository;
	
    @Autowired
    RabbitMQProducer rabbitMqProducer;
	
	@PostMapping("/createCustomerRequest")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<String> create(@RequestBody CustomerRequest requestDto) {
		System.out.println("inside createCustomer route");
		UserInfoUserDetails userInfo = (UserInfoUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Product productData = productRepository.findByProductName(requestDto.getProductName());
		
		UserRequest userRequest = new UserRequest();
		
		if(productData != null) {
			//ArrayList<ShopkeeperResponse> responses = shopkeeperResponseRepository.findByProductIdAndIsAvailableAndStockGreaterThan(productData.getId(), true, 0);
			System.out.println("inside if");
			userRequest.setProduct_id(productData.getId());
		}
		else {
			    Product product=new Product();
				product.setProductName(requestDto.getProductName());
				product.setProductURL(requestDto.getProductUrl());
				Product savedProduct = productRepository.save(product);
				userRequest.setProduct_id(savedProduct.getId());
		}
		
		
		
		
		userRequest.setUserId(userInfo.getId());
		userRequest.setCategory(requestDto.getCategory());
		
		userRequestRepository.save(userRequest);
		
		sendAsyncMessage("Message send to consumer ");
	    return ResponseEntity.ok("We will notify you soon...");
	    
	    
	}
	
    @Async
    public void sendAsyncMessage(String message) {
        rabbitMqProducer.sendMessage(message);
    }
	
//	@GetMapping("/getShopkeeperResponses")
//	@PreAuthorize("hasAuthority('ROLE_USER')")./
//	public ResponseEntity<ShopkeeperResponses> getResponses(){
//		UserInfoUserDetails userInfo = (UserInfoUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		
//		
//	}

}
