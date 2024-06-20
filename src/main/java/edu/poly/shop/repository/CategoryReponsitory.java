package edu.poly.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.poly.shop.domain.Category;

public interface CategoryReponsitory extends JpaRepository<Category, Long> {
	@Query("Select p  from Category p")
	List<Category>searchCategories();
}
