package ch.sf.demo.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ch.sf.demo.dao.ItemDao;
import ch.sf.demo.model.Item;

@Repository
public class ItemDaoImpl implements ItemDao{
	
	@PersistenceContext
	private EntityManager em;
	
	public Item getById(Long id){
		return em.find(Item.class, id);
	}
	
	public Item getByCodeTwo(String code){
		Query q = em.createQuery("SELECT a FROM Item a WHERE a.numberTwo = :code", Item.class);
		q.setParameter("code", code);
		return ((Item)q.getSingleResult());
	}

}
