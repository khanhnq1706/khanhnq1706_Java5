package edu.poly.shop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/customer")
public class UserController {
@GetMapping("/listuser")
public String listUser() {
	return "/admin/customers/customerManager";
	
}
}
