package edu.poly.shop.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import edu.poly.shop.domain.CartItem;
import edu.poly.shop.domain.Product;
import edu.poly.shop.service.ShoppingCartService;
@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService{
	Map<Long, CartItem> map = new HashMap<>();
@Override
public void add(CartItem item) {
	CartItem existItem = map.get(item.getProductId());
	if (existItem!=null) {
		existItem.setQuantity(existItem.getQuantity()+item.getQuantity());
	}
	else {
		map.put(item.getProductId(), item);
	}

	
}
@Override
public double getTotalPrice(Collection<CartItem> cartItems) {
    double totalPrice = 0.0;
    cartItems= getItems();
    for (CartItem item : cartItems) {
        totalPrice += item.getUnitPrice() * item.getQuantity();
    }
    return totalPrice;
}
@Override
public void remove(Long productId) {
	map.remove(productId);
}
@Override
public Collection<CartItem> getItems(){
	return map.values();
	
}
@Override
public void clear() {
	map.clear();
	
}
@Override
public void update(Long itemId, int quantity) {
	CartItem item = map.get(itemId);
	item.setQuantity(quantity);
	if (item.getQuantity() <=0) {
		map.remove(itemId);
	}
	
}
@Override
public double getAmount() {
	return map.values().stream().mapToDouble(item -> item.getQuantity() * item.getUnitPrice()).sum();
}
@Override
public int getCount() {
	if (map.isEmpty()) {
		return 0;
	}
	return map.size();
	
}

}
