package edu.poly.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import edu.poly.shop.domain.Account;
import edu.poly.shop.service.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthInterceptor implements  HandlerInterceptor{
@Autowired
SessionService sessionService;
 @Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		
		Account user = sessionService.get("currentUser");
		String error = "";
		if (user == null ) {
			error = "Please Login";
		}
		else if (!user.getRole().equals("Admin")&& uri.startsWith("/admin/")) {
			error = "Access denied!";
		}
		if (error.length()>0) {
			sessionService.set("security-uri", uri);
			response.sendRedirect("account/login?error=" +error);
			return false;
		}
		return true;
	}
}

