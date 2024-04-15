package com.javatechie.dto;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetails {
	private Integer id;
    private String name;
    private String password;
    private List<GrantedAuthority> authorities;
}
