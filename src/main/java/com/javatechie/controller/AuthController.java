package com.javatechie.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.config.UserInfoUserDetails;
import com.javatechie.dto.AuthRequest;
import com.javatechie.entity.ShopkeeperInfo;
import com.javatechie.entity.UserInfo;
import com.javatechie.repository.ShopkeeperInfoRepository;
import com.javatechie.repository.UserInfoRepository;
import com.javatechie.service.AuthService;
import com.javatechie.service.JwtService;


@RestController
@RequestMapping("/api")
public class AuthController {
	
    @Autowired
    private AuthService service;
    @Autowired
    private JwtService jwtService;
    
    @Autowired
    UserInfoRepository userInfoRepository;
    
    @Autowired
    ShopkeeperInfoRepository shopkeeperInfoRepository;
    
//    @Autowired
//    UserNotificationRepository userNotificationRepository;
    
//    @Autowired
//    ShopkeeperNotificationRepository shopkeeperNotificationRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/new")
    public ResponseEntity<String> addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }
    
    @PostMapping("/new/shopkeeper")
    public String addNewShopkeeper(@RequestBody ShopkeeperInfo shopkeeperInfo) {
        return service.addShopkeeper(shopkeeperInfo);
    }



    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        System.out.println("inside authentication request");
        if (authentication.isAuthenticated()) {
        	System.out.println("inside authentication isAuthenticated");
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
    

}
