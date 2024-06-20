package edu.poly.shop.service.impl;

import org.springframework.stereotype.Service;

import edu.poly.shop.repository.OrderDetailRepository;
@Service
public class OrderDetailServiceImpl {
OrderDetailRepository detailRepository1;
public OrderDetailServiceImpl(OrderDetailRepository detailRepository) {
this.detailRepository1 = detailRepository;
}
}
