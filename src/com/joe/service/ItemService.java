package com.joe.service;

import java.util.List;

import com.joe.po.Item;

public interface ItemService {
	public Item add(Item item);
	public Item delete(String iid);
	public List<Item> listAll();
	public Item queryOneById(String iid);
}
