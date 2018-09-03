package com.joe.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.joe.dao.ItemDao;
import com.joe.po.Item;

@Repository("itemDao")
@Transactional
public class ItemDaoImpl implements ItemDao {
	
	@PersistenceContext(name="em")
	private EntityManager em;

	
	@Override
	public Item add(Item item) {
		em.persist(item);
		return item;
	}

	@Override
	public Item delete(String iid) {
		Item i = em.find(Item.class, iid);
		em.remove(i);
		return i;
	}

	@Override
	public List<Item> listAll() {
		String jpql = "from Item order by Item";
		Query query = em.createQuery(jpql);
		List<Item> list = query.getResultList();
		return list;
	}

	@Override
	public Item queryOneById(String iid) {
		Item i = em.find(Item.class, iid);
		return i;
	}

	@Override
	public List<Item> listItemByBid(String bid) {
		String jpql = "select bid from item i where i.base.bid =:bid";
		Query query = em.createQuery(jpql);
		List<Item> list = query.getResultList();
		return list;
	}

}
