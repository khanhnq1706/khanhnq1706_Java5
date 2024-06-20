package edu.poly.shop.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.shop.common.PageInfo;
import edu.poly.shop.common.PageType;
import edu.poly.shop.domain.Category;
import edu.poly.shop.domain.Product;
import edu.poly.shop.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("admin/categories")
public class CategoryController {
	@Autowired
	CategoryService categoryServiceImpl;
	@Autowired
	HttpServletRequest request;
@PostMapping("/saveOrUpdate")
public String add(Model model , @ModelAttribute("item") Category categoryIem,@RequestParam("p") Optional<Integer> p) {
	categoryServiceImpl.saveAndFlush(categoryIem);
	model.addAttribute("item",categoryIem);
	 int pageIndex = Math.max(p.orElse(0), 0);
	Pageable pageable = PageRequest.of(pageIndex, 5);
	Page<Category> page = categoryServiceImpl.findAll(pageable);
	model.addAttribute("page", page);
	return "admin/index";
}
@GetMapping("/edit/{categoryId}")
public String edit(Model model , @ModelAttribute("item") Category categoryIem,@PathVariable("categoryId") Long categoryId,@RequestParam("p") Optional<Integer> p) {
	PageInfo pageInfo = PageInfo.pageRoute.get(PageType.CATEGORY_MANAGEMENT_PAGE);
	model.addAttribute("pageInfo", pageInfo);
	Optional<Category> existingCategory = categoryServiceImpl.findById(categoryIem.getCategoryId());
	if (existingCategory.isPresent()) {
        model.addAttribute("item", existingCategory.get());
      
    }
	 int pageIndex = Math.max(p.orElse(0), 0);
	Pageable pageable = PageRequest.of(pageIndex, 5);
	Page<Category> page = categoryServiceImpl.findAll(pageable);
	model.addAttribute("page", page);
	return "admin/index";
}

@GetMapping("/delete/{categoryId}")
public String delete(Model model , @ModelAttribute("item") Category categoryIem, @PathVariable("categoryId") Long categoryId,@RequestParam("p") Optional<Integer> p) {
	categoryServiceImpl.deleteById(categoryId);;
	PageInfo pageInfo = PageInfo.pageRoute.get(PageType.CATEGORY_MANAGEMENT_PAGE);
	model.addAttribute("pageInfo", pageInfo);
	int pageIndex = Math.max(p.orElse(0), 0);
	Pageable pageable = PageRequest.of(pageIndex, 5);
	Page<Category> page = categoryServiceImpl.findAll(pageable);
	model.addAttribute("page", page);
	return "/admin/index";

}
@GetMapping("/page")
public String list(Model model, @RequestParam("p") Optional<Integer> p,  @ModelAttribute("item") Category categoryIem) {
	 categoryIem = new Category();
	model.addAttribute("item",categoryIem);
	PageInfo pageInfo = PageInfo.pageRoute.get(PageType.CATEGORY_MANAGEMENT_PAGE);
	model.addAttribute("pageInfo", pageInfo);
	 int pageIndex = Math.max(p.orElse(0), 0);
	Pageable pageable = PageRequest.of(pageIndex, 5);
	Page<Category> page = categoryServiceImpl.findAll(pageable);
	model.addAttribute("page", page);
	return "admin/index";
}

}
