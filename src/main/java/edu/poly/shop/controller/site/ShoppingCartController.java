package edu.poly.shop.controller.site;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.shop.service.impl.ProductServiceImpl;
import edu.poly.shop.common.PageInfo;
import edu.poly.shop.common.PageType;
import edu.poly.shop.domain.Account;
import edu.poly.shop.domain.CartItem;
import edu.poly.shop.domain.Product;
import edu.poly.shop.service.ProductService;
import edu.poly.shop.service.SessionService;
import edu.poly.shop.service.ShoppingCartService;

@Controller
@RequestMapping("shoppingCart")
public class ShoppingCartController {
	@Autowired
	ShoppingCartService shoppingCartService;
	@Autowired
	ProductService productService;
	@Autowired
	ProductServiceImpl productServiceImpl;
	@Autowired
	SessionService sessionService;
	@GetMapping("listShoppingCart")
	public String list(Model model) {
		PageInfo pageInfo = PageInfo.pageRoute.get(PageType.SITE_SHOPPINGCART_PAGE);
		model.addAttribute("pageInfo", pageInfo);
		Collection<CartItem> cartItems = shoppingCartService.getItems();
		model.addAttribute("cartItems",cartItems);
		model.addAttribute("total",shoppingCartService.getAmount());
		model.addAttribute("NoOfItem",shoppingCartService.getCount());
		double totalPrice = shoppingCartService.getTotalPrice(cartItems);
		model.addAttribute("totalPrice",totalPrice);
		return "site/index";
	}

	@GetMapping("add/{productId}")
	public String add(Model model, @PathVariable("productId") Long productId) {
		
		PageInfo pageInfo = PageInfo.pageRoute.get(PageType.SITE_SHOPPINGCART_PAGE);
		model.addAttribute("pageInfo", pageInfo);
		Account account = sessionService.get("currentUser");
		Product product = productServiceImpl.getById(productId);
		if (product!=null) {
//			Product product1 = product.get();
			CartItem item = new CartItem(); 
			BeanUtils.copyProperties(product, item);
			item.setQuantity(1);
			shoppingCartService.add(item);
			
		}
		Collection<CartItem> cartItems = shoppingCartService.getItems();
		model.addAttribute("cartItems",cartItems);
		model.addAttribute("total",shoppingCartService.getAmount());
		model.addAttribute("NoOfItem",shoppingCartService.getCount());
		double totalPrice = shoppingCartService.getTotalPrice(cartItems);
		model.addAttribute("totalPrice",totalPrice);
		return "site/index";
	}
	@GetMapping("remove/{productId}")
	public String remove(Model  model,@PathVariable("productId") Long productId) {
		PageInfo pageInfo = PageInfo.pageRoute.get(PageType.SITE_SHOPPINGCART_PAGE);
		model.addAttribute("pageInfo", pageInfo);
		shoppingCartService.remove(productId);;
		Collection<CartItem> cartItems = shoppingCartService.getItems();
		model.addAttribute("cartItems",cartItems);
		model.addAttribute("total",shoppingCartService.getAmount());
		model.addAttribute("NoOfItem",shoppingCartService.getCount());
		double totalPrice = shoppingCartService.getTotalPrice(cartItems);
		model.addAttribute("totalPrice",totalPrice);
		return "site/index";
	}
	@PostMapping("update")
	String update(@RequestParam("productId") Long productId, @RequestParam("quantity") Integer quantity ) {
		shoppingCartService.update(productId, quantity);
		return "redirect:/site/shoppingCart";
	}

	@PostMapping("shoppingCart/clear")
	String clear() {
		shoppingCartService.clear();
		return "redirect:/site/shoppingCart";

	}
	
}
