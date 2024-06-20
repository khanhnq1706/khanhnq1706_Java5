package edu.poly.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.poly.shop.service.impl.GlobalInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	@Autowired
	GlobalInterceptor global;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(global)
		.addPathPatterns("/admin/**","/home/*","/account/changepw","/order/**")
		.excludePathPatterns("/assets/**","/admin/home/index");

}}
