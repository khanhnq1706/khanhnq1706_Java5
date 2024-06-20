package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.poly.shop.domain.Product;
import edu.poly.shop.repository.ProductRepository;

public interface ProductService {

	void deleteAll();

	<S extends Product> List<S> findAll(Example<S> example, Sort sort);

	<S extends Product> List<S> findAll(Example<S> example);

	void deleteAll(Iterable<? extends Product> entities);

	Product getReferenceById(Long id);

	void deleteAllById(Iterable<? extends Long> ids);

	void delete(Product entity);

	Product getById(Long id);

	void deleteById(Long id);

	long count();

	Product getOne(Long id);

	void deleteAllInBatch();

	<S extends Product> boolean exists(Example<S> example);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	boolean existsById(Long id);

	void deleteAllInBatch(Iterable<Product> entities);

	Optional<Product> findById(Long id);

	<S extends Product> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Product> entities);

	List<Product> findAll();

	<S extends Product> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Product> S saveAndFlush(S entity);

	Page<Product> findAll(Pageable pageable);

	void flush();

	List<Product> findAll(Sort sort);

	<S extends Product> Optional<S> findOne(Example<S> example);

	<S extends Product> List<S> saveAll(Iterable<S> entities);

	<S extends Product> S save(S entity);

}
