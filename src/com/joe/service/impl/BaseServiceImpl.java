package com.joe.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.joe.dao.BaseDao;
import com.joe.po.Base;
import com.joe.service.BaseService;

@Service("baseService")
public class BaseServiceImpl implements BaseService {
	
	@Resource(name="baseDao")
	private BaseDao baseDao;

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public Base add(Base base) {
		// TODO Auto-generated method stub
		return baseDao.add(base);
	}

	@Override
	public Base delete(String bid) {
		// TODO Auto-generated method stub
		return baseDao.delete(bid);
	}

	@Override
	public List<Base> listAll() {
		// TODO Auto-generated method stub
		return baseDao.listAll();
	}

	@Override
	public Base queryOneById(String bid) {
		// TODO Auto-generated method stub
		return baseDao.queryOneById(bid);
	}
	
}
