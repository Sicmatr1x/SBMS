package com.joe.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		String requestURL = request.getRequestURL().toString();
		
		if(requestURL.contains("login")) {
			return true;
		}
		if(userId == null) {
			return false;
		}
//		System.out.println("LoginInterceptor:preHandle:login=" + userId.toString());
//		System.out.println("LoginInterceptor:preHandle:" + request.getRequestURL());
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//		System.out.println("Interceptor1:postHandle");
		super.postHandle(request, response, handler, modelAndView);
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
//		System.out.println("Interceptor1:afterCompletion");
		super.afterCompletion(request, response, handler, ex);
	}
}
