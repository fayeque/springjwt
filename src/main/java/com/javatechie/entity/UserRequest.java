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
public class UserRequest {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int product_id;
    
    //User id of the user requesting for the product
    private int userId;
    
    private String category;
    
    @Column(name = "creation_time", nullable = false)
    private LocalDateTime creationTime;
    
    @PrePersist
    public void prePersist() {
        this.creationTime = LocalDateTime.now();
    }

}
