package com.javatechie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javatechie.entity.ShopkeeperInfo;
import com.javatechie.entity.UserInfo;
import com.javatechie.repository.ShopkeeperInfoRepository;
import com.javatechie.repository.UserInfoRepository;

@Service
public class AuthService {

	
//  List<Product> productList = null;
//
  @Autowired
  private UserInfoRepository repository;
  @Autowired
  private ShopkeeperInfoRepository shopkeeperRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;
//
//  @PostConstruct
//  public void loadProductsFromDB() {
//      productList = IntStream.rangeClosed(1, 100)
//              .mapToObj(i -> Product.builder()
//                      .productId(i)
//                      .name("product " + i)
//                      .qty(new Random().nextInt(10))
//                      .price(new Random().nextInt(5000)).build()
//              ).collect(Collectors.toList());
//  }
//
//
//  public List<Product> getProducts() {
//      return productList;
//  }
//
//  public Product getProduct(int id) {
//      return productList.stream()
//              .filter(product -> product.getProductId() == id)
//              .findAny()
//              .orElseThrow(() -> new RuntimeException("product " + id + " not found"));
//  }
//
//
  public ResponseEntity<String> addUser(UserInfo userInfo) {
      if (repository.findByEmail(userInfo.getEmail()) != null) {
      	 return ResponseEntity.badRequest().body("Username is already taken");
      }
      userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
      repository.save(userInfo);
      return ResponseEntity.ok("User added successfully");
  }
  
  public String addShopkeeper(ShopkeeperInfo shopkeeperInfo) {
  	shopkeeperInfo.setPassword(passwordEncoder.encode(shopkeeperInfo.getPassword()));
  	shopkeeperRepository.save(shopkeeperInfo);
      return "user added to system ";
  }
  
}
