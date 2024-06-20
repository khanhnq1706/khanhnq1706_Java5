package edu.poly.shop.controller.site;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import edu.poly.shop.domain.Account;
import edu.poly.shop.domain.AccountRole;
import edu.poly.shop.domain.AccountStatus;
import edu.poly.shop.repository.AccountRepository;
import edu.poly.shop.service.SessionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class AccountController {
@Autowired
AccountRepository accountRepository;
@Autowired
SessionService sessionService;
@GetMapping("account/login")
public String login(Model model,@ModelAttribute("account") Account account) {
    return "site/loginAndRegister";
}
@PostMapping("account/login")
public String login (Model model, @RequestParam("usernameOrEmail") String username, @RequestParam("password") String password) {
	Account user = accountRepository.findByUsernameOrEmailAndPassword(username, password);
	try {
		
		System.out.println("username: " + user.getUsername());
		System.out.println("pass: " + user.getPassword());
		if (user!=null) {
			sessionService.set("currentUser", user);
			model.addAttribute("isLogin", true);
			model.addAttribute("message", "Login succeed");
			
			return "redirect:/home/index";
				
				} 		
	} catch (Exception e) {
		model.addAttribute("message","Invalid username");
		
	}
	
	return "site/loginAndRegister";
}
@PostMapping("account/register")
public String register(Model model, @ModelAttribute("account") Account account) {
	// Handle login or registration based on form submission
	List<Account> accounts = accountRepository.findAll();
	Account ac =  accountRepository.findByUsernameOrEmail(account.getUsername(), account.getEmail());

    if (ac!=null) {
   
    	 System.out.println(account);
         model.addAttribute("message"," Uername or email is exit");
        return "/site/loginAndRegister";
    } else {
    	account.setAccountStatus(AccountStatus.Activated);
        account.setRole(AccountRole.User);
        account.setPhoto("default.png");
        accountRepository.saveAndFlush(account);
        model.addAttribute("message"," Đăng kí thành công!");
    	System.out.println(account);
    }
    return "/site/loginAndRegister";
}

}

