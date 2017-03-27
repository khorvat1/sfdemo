package ch.sf.demo.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import ch.sf.demo.dao.ItemDao;
import ch.sf.demo.model.Item;

@Repository
public class ItemDaoImpl implements ItemDao{
	
	final static Logger log = Logger.getLogger(ItemDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	public Item getById(Long id){
		return em.find(Item.class, id);
	}
	
	public Item getByCodeTwo(String code){
		Item i = null;
		try {
			Query q = em.createQuery("SELECT a FROM Item a WHERE a.numberTwo = :code", Item.class);
			q.setParameter("code", code);
			i = (Item)q.getSingleResult();
			return i;
			
		} catch (Exception e){
			log.warn("Data not found", e);
			return null;
		}
	}

}
