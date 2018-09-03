package com.joe.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joe.po.Base;
import com.joe.service.BaseService;

public class BaseServiceImplTest {
	
	private BaseService baseService;
	
	@Before
	public void before() {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		baseService = (BaseService) classPathXmlApplicationContext.getBean("baseService");
	}
	
	@After
	public void after() {
		
	}

	@Test
	public void testAdd() {
		Base base = new Base();
		base.setBaseName("JunitTest");
		Base actural = baseService.add(base);
		System.out.println(actural);
		assertNotNull(actural);
	}

//	@Test
	public void testDelete() {
		Base actural = baseService.delete("8a5e9d4964efd9fc0164eff0279f0007");
		assertNotNull(actural);
	}

	@Test
	public void testListAll() {
		System.out.println(baseService);
		List<Base> list = baseService.listAll();
		System.out.println(list);
		assertNotNull(list);
	}

//	@Test
	public void testQueryOneById() {
		Base actural = baseService.queryOneById("8a5e9d4964efd9fc0164eff0279f0007");
		assertNotNull(actural);
	}

}
