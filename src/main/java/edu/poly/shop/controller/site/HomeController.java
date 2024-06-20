package edu.poly.shop.controller.site;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.shop.common.PageInfo;
import edu.poly.shop.common.PageType;
import edu.poly.shop.domain.Product;
import edu.poly.shop.repository.ProductRepository;
import edu.poly.shop.service.SessionService;

@RequestMapping("/home")
@Controller
public class HomeController {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	SessionService sessionService;
@GetMapping("index")
public String index(Model model, @RequestParam("p") Optional<Integer> p) {
	PageInfo pageInfo = PageInfo.pageRoute.get(PageType.SITE_HOME_PAGE);
	model.addAttribute("pageInfo", pageInfo);
	int pageIndex = Math.max(p.orElse(0), 0);
	Pageable pageable = PageRequest.of(pageIndex, 5);
	Page<Product> page = productRepository.findAll(pageable);
	model.addAttribute("page", page);
	return "site/index";
}
@RequestMapping("/home/contact")
public String about() {
	
	return "/site/contact";
}
@RequestMapping("/home/shoppingcart")
public String shoppingCart() {
	
	return "site/shoppingCart";
}
@RequestMapping("/home/editprofie")
public String editProfile() {
	
	return "site/editProfile";
}
@RequestMapping("/home/loginandregister")
public String loginAndRegister() {
	
	return "site/loginAndRegister";
}
@RequestMapping("/home/productdetail")
public String productDetail() {
	
	return "site/productDetail";
}
@GetMapping("/logoff")
public String logOff(Model model) {
	
	sessionService.remove("currentUser");
	return "redirect:/home/index";
}
@GetMapping(value = "page",params = "last")
public String page(Model model, @RequestParam("p") Optional<Integer> p) {
	PageInfo pageInfo = PageInfo.pageRoute.get(PageType.SITE_HOME_PAGE);
	model.addAttribute("pageInfo", pageInfo);
	int pageIndex = Math.max(p.orElse(0), 0);
	Pageable pageable = PageRequest.of(pageIndex, 5);
	Page<Product> page = productRepository.findAll(pageable);
	model.addAttribute("page", page);
	return "site/index";
}
@GetMapping("/search")
public String search(Model model, @RequestParam("nameSearch") String name,@RequestParam("p") Optional<Integer> p) {
	
	PageInfo pageInfo = PageInfo.pageRoute.get(PageType.SITE_HOME_PAGE);
	model.addAttribute("pageInfo", pageInfo);
	int pageIndex = Math.max(p.orElse(0), 0);
	Pageable pageable = PageRequest.of(pageIndex, 5);
	Page<Product> page = productRepository.findByKeywords(name, pageable);
	model.addAttribute("page", page);
	return "redirect:/home/index";
}
}
