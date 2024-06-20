package edu.poly.shop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.Category;
import edu.poly.shop.repository.CategoryReponsitory;
//import edu.poly.shop.repository.CategoryReponsitory;
import edu.poly.shop.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {


	CategoryReponsitory categoryReponsitory;
public CategoryServiceImpl(CategoryReponsitory categoryReponsitory1) {
	this.categoryReponsitory = categoryReponsitory1;
}
@Override
public <S extends Category> S save(S entity) {
	
	return categoryReponsitory.save(entity);
}
@Override
public <S extends Category> List<S> saveAll(Iterable<S> entities) {
	return categoryReponsitory.saveAll(entities);
}
@Override
public List<Category> findAll(Sort sort) {
	return categoryReponsitory.findAll(sort);
}
@Override
public void flush() {
	categoryReponsitory.flush();
}
@Override
public Page<Category> findAll(Pageable pageable) {
	return categoryReponsitory.findAll(pageable);
}
@Override
public <S extends Category> S saveAndFlush(S entity) {
	return categoryReponsitory.saveAndFlush(entity);
}
@Override
public <S extends Category> List<S> saveAllAndFlush(Iterable<S> entities) {
	return categoryReponsitory.saveAllAndFlush(entities);
}
@Override
public List<Category> findAll() {
	return categoryReponsitory.findAll();
}
@Override
public List<Category> findAllById(Iterable<Long> ids) {
	return categoryReponsitory.findAllById(ids);
}
@Override
public void deleteInBatch(Iterable<Category> entities) {
	categoryReponsitory.deleteInBatch(entities);
}

@Override
public Optional<Category> findById(Long id) {
	return categoryReponsitory.findById(id);
}
@Override
public void deleteAllInBatch(Iterable<Category> entities) {
	categoryReponsitory.deleteAllInBatch(entities);
}
@Override
public boolean existsById(Long id) {
	return categoryReponsitory.existsById(id);
}
@Override
public void deleteAllByIdInBatch(Iterable<Long> ids) {
	categoryReponsitory.deleteAllByIdInBatch(ids);
}
@Override
public <S extends Category> boolean exists(Example<S> example) {
	return categoryReponsitory.exists(example);
}
@Override
public void deleteAllInBatch() {
	categoryReponsitory.deleteAllInBatch();
}
@Override
public long count() {
	return categoryReponsitory.count();
}
@Override
public void deleteById(Long id) {
	categoryReponsitory.deleteById(id);
}
@Override
public Category getById(Long id) {
	return categoryReponsitory.getById(id);
}
@Override
public void delete(Category entity) {
	categoryReponsitory.delete(entity);
}
@Override
public void deleteAllById(Iterable<? extends Long> ids) {
	categoryReponsitory.deleteAllById(ids);
}
@Override
public void deleteAll(Iterable<? extends Category> entities) {
	categoryReponsitory.deleteAll(entities);
}
@Override
public void deleteAll() {
	categoryReponsitory.deleteAll();
}

}
