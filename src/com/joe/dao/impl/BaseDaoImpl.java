package com.joe.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.joe.dao.BaseDao;
import com.joe.po.Base;

@Repository("baseDao")
@Transactional
public class BaseDaoImpl implements BaseDao {
	
	@PersistenceContext(name="em")
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Base add(Base base) {
		em.persist(base);
		return base;
	}

	@Override
	public Base delete(String bid) {
		Base b = em.find(Base.class, bid);
		em.remove(b);
		return b;
	}

	@Override
	public List<Base> listAll() {
		String jpql = "from Base order by Base";
		Query query = em.createQuery(jpql);
		List<Base> list = query.getResultList();
		return list;
	}

	@Override
	public Base queryOneById(String bid) {
		Base b = em.find(Base.class, bid);
		return b;
	}

	

}
