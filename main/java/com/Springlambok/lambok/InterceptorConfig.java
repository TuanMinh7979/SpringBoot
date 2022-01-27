package com.Springlambok.lambok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.Springlambok.lambok.interceptor.AuthenticateInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
    @Autowired
    private AuthenticateInterceptor authenticateInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(authenticateInterceptor).addPathPatterns("/admin/**", "/users/**").excludePathPatterns("/login", "/register");
	}

}
