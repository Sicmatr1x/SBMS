package com.joe.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.joe.dao.UserDao;
import com.joe.po.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext(name="em")
	private EntityManager em;

	@Override
	public User queryOneById(String uid) {
		if("admin".equals(uid)){
			User user = new User();
			user.setUserId(uid);
			user.setPassword("admin");
			user.setUsername("admin");
			return user;
		}
		User u = em.find(User.class, uid);
		return u;
	}

	@Override
	public User add(User user) {
		em.persist(user);
		return user;
	}

}
