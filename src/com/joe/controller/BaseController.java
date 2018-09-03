package com.joe.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joe.po.Base;
import com.joe.service.BaseService;

@RestController
@RequestMapping("/base")
public class BaseController {

	@Resource(name="baseService")
	private BaseService baseService;
	
	@PostMapping
	public Base add(Base base) {
		System.out.println("BaseController:add:base=" + base);
		
		return baseService.add(base);
	}
	
	@DeleteMapping("/{bid}")
	public Base deleteById(@PathVariable String bid) {
		System.out.println("BaseController:deleteById:iid=" + bid);
		return baseService.delete(bid);
	}
	
	@GetMapping("/list")
	public List<Base> listAll(){
		List<Base> list = baseService.listAll();
		System.out.println("BaseController:listAll:" + list);
		return list;
	}
	
	@GetMapping("/{bid}")
	public Base listOne(@PathVariable String bid){
		Base base = baseService.queryOneById(bid);
		System.out.println("BaseController:listOne:bid=" + bid + "," + base);
		return base;
	}
}
