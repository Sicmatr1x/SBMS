package com.joe.service;

import java.util.List;

import com.joe.po.Base;

public interface BaseService {
	public Base add(Base base);
	public Base delete(String bid);
	public List<Base> listAll();
	public Base queryOneById(String bid);
}
