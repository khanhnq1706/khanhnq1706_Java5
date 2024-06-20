package edu.poly.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.shop.domain.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

}
