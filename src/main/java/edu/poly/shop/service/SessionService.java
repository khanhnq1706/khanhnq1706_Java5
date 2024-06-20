package edu.poly.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.Account;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class SessionService {
@Autowired
HttpSession session;
@Autowired
ServletContext app;
public <T> T get(String name) {
	T att = (T) session.getAttribute(name);
	if (att != null) {
		return att;
	}
		return null;
}
public void set(String name, Object value) {
	session.setAttribute(name, value);
	
}
public void remove(String name) {
	session.removeAttribute(name);
	
}
public  boolean isLogin(String name) {
	return  get(name) !=null;
} 
}
