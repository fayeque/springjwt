package com.javatechie.entity;

import java.util.Set;

import org.hibernate.annotations.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopkeeperInfo {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String name;
	    private String email;
	    private String password;
	    private String roles;
	    private String address;
	    private String category;
	    private int mobile;
	    @Column(columnDefinition = "POINT")
	    private Point location;
	    
//	    @OneToMany(mappedBy="shopkeeperInfo")
//	    private Set<ShopkeeperNotification> shopkeeperNotifications;
}
