package com.javatechie.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopkeeperInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private String productUrl;
    private String productPrice;
    private String productDescription;
    private int stock;
    private int shopkeeper_id;
    
    @Column(name = "creation_time", nullable = false)
    private LocalDateTime creationTime;
    
    @PrePersist
    public void prePersist() {
        this.creationTime = LocalDateTime.now();
    }

}
