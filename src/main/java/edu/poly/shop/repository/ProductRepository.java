package edu.poly.shop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.poly.shop.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByNameContainingIgnoreCase(String name);
	
	List<Product> findByUnitPrice(Double unitPrice);
	
	
	
	
//	@Query("SELECT p FROM Product p WHERE p.unitPrice BETWEEN :minUnitPrice AND :maxUnitPrice")
//    List<Product> findByUnitPriceBetween(Double minUnitPrice, Double maxUnitPrice);
	
	
	
	@Query("SELECT o FROM Product o WHERE o.name LIKE ?1")
	Page<Product> findByKeywords(String keywords, Pageable pageable);
	
	List<Product> findByUnitPriceBetween(Double minUnitPrice, Double maxUnitPrice);

}
