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
public class ShopkeeperResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String product_price;
    private int user_request_id;
    private int user_id;
    private boolean is_visited;
    private boolean is_available;
    private int product_id;
    private int stock;
    private int shopkeeper_id;
    private String category;
    private String comments;
    private boolean is_viewed;
    private String product_name;
      
    
    @Column(name = "creation_time", nullable = false)
    private LocalDateTime creationTime;
    
    @PrePersist
    public void prePersist() {
        this.creationTime = LocalDateTime.now();
    }

    
}
