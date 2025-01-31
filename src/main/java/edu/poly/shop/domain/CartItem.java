package edu.poly.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
	private Long productId;
	private String imageUrl;
	private String name;
	private int quantity;
	private double unitPrice;
}
