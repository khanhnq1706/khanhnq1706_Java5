package edu.poly.shop.controller.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.shop.domain.MailInfo;
import edu.poly.shop.service.impl.MailerServiceImpl;
import jakarta.mail.MessagingException;
@Controller
public class MailerCotroller {
@Autowired
MailerServiceImpl mailerServiceImpl;
@RequestMapping("/site/SendMail")
public String send() {
	try {
		MailInfo mail = new MailInfo("khanhzalo321@gmail.com", "abcxyz", "Xin chao");
		mail.setFrom("khanhnqpd07365@fpt.edu.vn");
		mailerServiceImpl.push(mail);
		mailerServiceImpl.run();
	} catch (MessagingException e) {
		e.printStackTrace();
	}
	return "/site/SendMail";
}
}
