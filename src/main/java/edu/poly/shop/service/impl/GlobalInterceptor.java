package edu.poly.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Service
public class GlobalInterceptor implements HandlerInterceptor {
@Autowired
CategoryServiceImpl categoryServiceImpl;
@Override
public boolean preHandle(HttpServletRequest request,
HttpServletResponse response, Object handler) throws Exception {
request.setAttribute("uri", request.getRequestURI());
return true;
}
@Override
public void postHandle(HttpServletRequest req, HttpServletResponse res, 
Object handler, ModelAndView mv) throws Exception {
req.setAttribute("categories", categoryServiceImpl.findAll());
}
}
