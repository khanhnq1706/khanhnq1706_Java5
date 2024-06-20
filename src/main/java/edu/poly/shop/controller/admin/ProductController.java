package edu.poly.shop.controller.admin;


import java.io.IOException;
import java.io.InputStream;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import edu.poly.shop.common.PageInfo;
import edu.poly.shop.common.PageType;
import edu.poly.shop.domain.Category;
import edu.poly.shop.domain.Product;
import edu.poly.shop.repository.CategoryReponsitory;
import edu.poly.shop.repository.ProductRepository;
import edu.poly.shop.service.SessionService;
import edu.poly.shop.service.impl.CategoryServiceImpl;
import edu.poly.shop.service.impl.ProductServiceImpl;
import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("/admin/products")

public class ProductController {
	@Autowired
	ProductServiceImpl productServiceImpl;
	@Autowired
	CategoryServiceImpl categoryServiceImpl;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryReponsitory categoryReponsitory;
	@Autowired
	ServletContext app;
	@Autowired
	SessionService session;

	@PostMapping("/saveOrUpdate")
	public String add(Model model , @ModelAttribute("productItem") Product productItem, @RequestParam("image") MultipartFile imageFile,@RequestParam("categories") Category category,
			
			 @RequestParam("p") Optional<Integer> p) throws IOException {
//		Category selectedCategory = categoryServiceImpl.getById(categoryId);
		productItem.setCategory(category);
		if (imageFile != null&&!imageFile.isEmpty()) {
			String path = app.getRealPath("/");
			System.out.println("path: " + path);
		try {
			 String originalFilename = imageFile.getOriginalFilename();
			
			String filePath = path + "/images/"+ originalFilename;
			productItem.setImageUrl(originalFilename);
			System.out.println("image name: " + productItem.getImageUrl());
			
		} catch (Exception e) {
		throw new IOException("Could not save upload file: " + productItem.getImageUrl());
	}}
		PageInfo pageInfo = PageInfo.pageRoute.get(PageType.PRODUCT_MANAGEMENT_PAGE);
		model.addAttribute("pageInfo", pageInfo);
		System.out.println("product id:" + productItem.getProductId());
	productServiceImpl.saveAndFlush(productItem);
	 int pageIndex = Math.max(p.orElse(0), 0);
	Pageable pageable = PageRequest.of(pageIndex, 5);
	Page<Product> page = productRepository.findAll(pageable);
	model.addAttribute("page", page);
	List<Category> categories = categoryReponsitory.searchCategories();
    model.addAttribute("categories", categories);
		return "/admin/index";
	}
	@PostMapping("/edit/{productId}")
	public String edit(Model model, @ModelAttribute("productItem") Product productItem, @PathVariable("productId") Long productId, @RequestParam("p") Optional<Integer> p) {
	    Optional<Product> existingProduct = productServiceImpl.findById(productId);
	    if (existingProduct.isPresent()) {
	        model.addAttribute("productItem", existingProduct.get());
	    }
	    PageInfo pageInfo = PageInfo.pageRoute.get(PageType.PRODUCT_MANAGEMENT_PAGE);
		model.addAttribute("pageInfo", pageInfo);
	    List<Category> categories = categoryReponsitory.searchCategories();
	    model.addAttribute("categories", categories);
	    int pageIndex = Math.max(p.orElse(0), 0);
		Pageable pageable = PageRequest.of(pageIndex, 5);
		Page<Product> page = productServiceImpl.findAll(pageable);
	    model.addAttribute("page", page);
	    return "/admin/index";
	}
@PostMapping("/delete/{productId}")
	public String delete(Model model , @ModelAttribute("productItem") Product productItem, @PathVariable("productId") Long productId,@RequestParam("p") Optional<Integer> p) {
		productServiceImpl.deleteById(productId);
		PageInfo pageInfo = PageInfo.pageRoute.get(PageType.PRODUCT_MANAGEMENT_PAGE);
		model.addAttribute("pageInfo", pageInfo);
		int pageIndex = Math.max(p.orElse(0), 0);
		Pageable pageable = PageRequest.of(pageIndex, 5);
		Page<Product> page = productRepository.findAll(pageable);
		model.addAttribute("page", page);
		return "admin/index";

	}

	@GetMapping("sort")
	public String sort(Model model, 
	@RequestParam("field") Optional<String> field) {
	Sort sort = Sort.by(Direction.DESC, field.orElse("price"));
	model.addAttribute("field", field.orElse("price").toUpperCase());
	List<Product> items = productServiceImpl.findAll(sort);
	model.addAttribute("items", items);
	return "/admin/products/list";
	}
	@GetMapping("page")
	public String list(Model model, @RequestParam("p") Optional<Integer> p,  @ModelAttribute("productItem") Product product) {
		model.addAttribute("item",product);
		PageInfo pageInfo = PageInfo.pageRoute.get(PageType.PRODUCT_MANAGEMENT_PAGE);
		model.addAttribute("pageInfo", pageInfo);
		 int pageIndex = Math.max(p.orElse(0), 0);
		Pageable pageable = PageRequest.of(pageIndex, 5);
		Page<Product> page = productRepository.findAll(pageable);
		model.addAttribute("page", page);
		return "admin/index";
	}

}
