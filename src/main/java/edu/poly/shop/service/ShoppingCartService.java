package edu.poly.shop.service;

import java.util.Collection;

import edu.poly.shop.domain.CartItem;


public interface ShoppingCartService {

	int getCount();

	double getAmount();



	Collection<CartItem> getItems();

	void add(CartItem item);
	
	double getTotalPrice(Collection<CartItem> cartItems);

	void update(Long itemId, int quantity);

	void clear();

	void remove(Long productId);
}
