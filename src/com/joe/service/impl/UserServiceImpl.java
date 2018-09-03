package com.joe.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.joe.dao.UserDao;
import com.joe.po.User;
import com.joe.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userDao")
	private UserDao userDao;

	@Override
	public boolean login(User user) {
		System.out.println("UserServiceImpl:" + user);
		if(user == null || user.getUserId() == null || user.getPassword() == null) {
			return false;
		}
		User result = userDao.queryOneById(user.getUserId());
		if(result.getPassword().equals(user.getPassword())) {
			return true;
		}
		return false;
	}

	

}
