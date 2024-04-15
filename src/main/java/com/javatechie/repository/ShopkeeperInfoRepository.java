package com.javatechie.repository;


import com.javatechie.entity.ShopkeeperInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopkeeperInfoRepository extends JpaRepository<ShopkeeperInfo, Integer> {
    ShopkeeperInfo findByEmail(String username);

}

