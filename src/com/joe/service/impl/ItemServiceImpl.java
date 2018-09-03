package com.joe.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.joe.dao.ItemDao;
import com.joe.po.Item;
import com.joe.service.ItemService;

@Service("itemService")
public class ItemServiceImpl implements ItemService {
	
	@Resource(name="itemDao")
	private ItemDao itemDao;

	@Override
	public Item add(Item item) {
		// TODO Auto-generated method stub
		return itemDao.add(item);
	}

	@Override
	public Item delete(String iid) {
		// TODO Auto-generated method stub
		return itemDao.delete(iid);
	}
	

	@Override
	public List<Item> listAll() {
		// TODO Auto-generated method stub
		return itemDao.listAll();
	}

	@Override
	public Item queryOneById(String iid) {
		// TODO Auto-generated method stub
		return itemDao.queryOneById(iid);
	}




	

}
