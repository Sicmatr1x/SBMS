package com.joe.dao;

import java.util.List;

import com.joe.po.Base;

public interface BaseDao {
	public Base add(Base base);
	public Base delete(String bid);
	public List<Base> listAll();
	public Base queryOneById(String bid);
}
