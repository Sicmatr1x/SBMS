package com.joe.dao;

import java.util.List;

import com.joe.po.Item;

public interface ItemDao {
	public Item add(Item item);
	public Item delete(String iid);
	public List<Item> listAll();
	public Item queryOneById(String iid);
	public List<Item> listItemByBid(String bid);
}
