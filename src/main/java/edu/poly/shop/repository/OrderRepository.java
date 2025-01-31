package edu.poly.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.shop.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
