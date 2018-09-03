package com.joe.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joe.po.User;
import com.joe.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(value = "/login/{userId}",method=RequestMethod.POST)
	public String post(@PathVariable String userId, User user, HttpSession session, HttpServletResponse response) throws IOException {
		System.out.println("UserController:get:userId=" + userId + "," + user);
		
		boolean flag = false;
		if(userId != null && user.getUserId() == null) {
			user.setUserId(userId);
		}
		flag = userService.login(user);
		if(flag) {
			session.setAttribute("userId", userId);
			response.sendRedirect("home");
			return "home";
			
		}else {
			response.sendRedirect("login");
			return "login";
		}
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public String get() {
		return "login";
	}
	
	@RequestMapping(value = "/home",method=RequestMethod.GET)
	public String home() {
		return "home";
	}
}
