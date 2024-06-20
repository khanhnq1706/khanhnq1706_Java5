package edu.poly.shop.controller.site;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.shop.common.PageInfo;
import edu.poly.shop.common.PageType;
import edu.poly.shop.domain.Product;
import edu.poly.shop.repository.ProductRepository;

@Controller
@RequestMapping("/home")
public class ListProductController {
	@Autowired
	ProductRepository productRepository;
	@GetMapping("/home/page")
	public String list(Model model, @RequestParam("p") Optional<Integer> p) {
		PageInfo pageInfo = PageInfo.pageRoute.get(PageType.SITE_HOME_PAGE);
		model.addAttribute("pageInfo", pageInfo);
		 int pageIndex = Math.max(p.orElse(0), 0);
		Pageable pageable = PageRequest.of(pageIndex, 8);
		Page<Product> page = productRepository.findAll(pageable);
		model.addAttribute("page", page);
		return "site/index";
	}
}
