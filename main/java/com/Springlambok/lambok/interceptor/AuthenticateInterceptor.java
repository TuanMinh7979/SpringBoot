package com.Springlambok.lambok.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticateInterceptor implements HandlerInterceptor {

	public boolean preHandler(HttpServletRequest request,HttpServletResponse response, Object handler) throws IOException {
		
		HttpSession session= request.getSession();
		if(session.getAttribute("user")==null) {
			session.setAttribute("error", "vui long dang nhap");
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
		return true;
	}
}
