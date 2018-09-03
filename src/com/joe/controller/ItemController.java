package com.joe.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joe.po.Item;
import com.joe.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Resource(name="itemService")
	private ItemService itemService;
	
	@PostMapping
	public Item add(Item item) {
		System.out.println("ItemController:add:item=" + item);
		
		return itemService.add(item);
	}
	
	@DeleteMapping("/{iid}")
	public Item deleteById(@PathVariable String iid) {
		System.out.println("ItemController:deleteById:iid=" + iid);
		return itemService.delete(iid);
	}
	
	@GetMapping("/list")
	public List<Item> listAll(){
		List<Item> list = itemService.listAll();
		System.out.println("ItemController:listAll:" + list);
		return list;
	}
	
	@GetMapping("/{iid}")
	public Item listOne(@PathVariable String iid){
		Item item = itemService.queryOneById(iid);
		System.out.println("ItemController:listOne:iid=" + iid + "," + item);
		return item;
	}
}
