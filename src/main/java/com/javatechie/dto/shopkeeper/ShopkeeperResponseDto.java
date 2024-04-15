package com.javatechie.dto.shopkeeper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopkeeperResponseDto {


		public int userRequestId;
		public String productPrice;
		public String productDescription;
		public String productName;
		public String productUrl;
		public int userId;
		public boolean availablility;
		public int stock;


}
