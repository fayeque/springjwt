package com.javatechie.dto.customer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
	
	public String productName;
	public String productUrl;
	public String productDescription;
	public String category;
	

}
