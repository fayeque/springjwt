package com.javatechie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.config.ShopkeeperInfoShopkeeperDetails;
import com.javatechie.config.UserInfoUserDetails;
import com.javatechie.dto.customer.CustomerRequest;
import com.javatechie.dto.shopkeeper.ShopkeeperResponseDto;
import com.javatechie.entity.Product;
import com.javatechie.entity.ShopkeeperInventory;
import com.javatechie.entity.ShopkeeperResponse;
import com.javatechie.entity.UserRequest;
import com.javatechie.repository.ProductRepository;
import com.javatechie.repository.ShopkeeperInventoryRepository;
import com.javatechie.repository.ShopkeeperResponseRepository;
import com.javatechie.repository.UserRequestRepository;

@RestController
@RequestMapping("/api/shopkeeper")
public class ShopkeeperController {
	@Autowired
	ShopkeeperResponseRepository shopkeeperResponseRepository;
	
	@Autowired
	ShopkeeperInventoryRepository shopkeeperInventoryRepository;
	
	
	
	@PostMapping("/createShopkeeperResponse")
//	@PreAuthorize("hasAuthority('ROLE_SHOPKEEPER')")
	public ResponseEntity<String> create(@RequestBody ShopkeeperResponseDto responseDto) {
		ShopkeeperInfoShopkeeperDetails userInfo = (ShopkeeperInfoShopkeeperDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		//create shopkeeper inventory and add that id to shopkeeper response
		
		

		
        ShopkeeperResponse shopkeeperResponse=new ShopkeeperResponse();
        

        shopkeeperResponse.setUser_id(responseDto.getUserId());
        shopkeeperResponse.setUser_request_id(responseDto.getUserRequestId());
        shopkeeperResponse.setShopkeeper_id(userInfo.getId());
        
        if(!responseDto.availablility) {
        shopkeeperResponse.set_available(false);
        }else {

    		shopkeeperResponse.set_available(true);
            shopkeeperResponse.set_visited(false);

        }
        
        shopkeeperResponseRepository.save(shopkeeperResponse);
		
	    return ResponseEntity.ok("Response sent and inventory created successfully");
	}
}
