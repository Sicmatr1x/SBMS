package com.joe.dao;

import com.joe.po.User;

public interface UserDao {
	public User add(User user);
	public User queryOneById(String uid);
}
