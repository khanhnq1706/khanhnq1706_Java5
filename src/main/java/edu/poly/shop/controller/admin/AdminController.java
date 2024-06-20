package edu.poly.shop.controller.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.shop.common.PageInfo;
import edu.poly.shop.common.PageType;
import edu.poly.shop.domain.Category;
import edu.poly.shop.domain.Product;
import edu.poly.shop.repository.CategoryReponsitory;
import edu.poly.shop.repository.ProductRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
@Autowired
CategoryReponsitory categoryReponsitory;
@Autowired
ProductRepository productRepository;
@GetMapping("CategoryManagerServlet")
public String list(Model model, @RequestParam("p") Optional<Integer> p,  @ModelAttribute("item") Category categoryIem) {
	 categoryIem = new Category();
	model.addAttribute("item",categoryIem);
	PageInfo pageInfo = PageInfo.pageRoute.get(PageType.CATEGORY_MANAGEMENT_PAGE);
	model.addAttribute("pageInfo", pageInfo);
	 int pageIndex = Math.max(p.orElse(0), 0);
	Pageable pageable = PageRequest.of(pageIndex, 5);
	Page<Category> page = categoryReponsitory.findAll(pageable);
	model.addAttribute("page", page);
	return "admin/index";
}
@GetMapping("home")
public String list(Model model, @RequestParam("p") Optional<Integer> p,  @ModelAttribute("productItem") Product product) {
	 product = new Product();
	model.addAttribute("productItem",product);
	PageInfo pageInfo = PageInfo.pageRoute.get(PageType.PRODUCT_MANAGEMENT_PAGE);
	model.addAttribute("pageInfo", pageInfo);
	 int pageIndex = Math.max(p.orElse(0), 0);
	Pageable pageable = PageRequest.of(pageIndex, 5);
	Page<Product> page = productRepository.findAll(pageable);
	model.addAttribute("page", page);
	return "admin/index";
}
}
