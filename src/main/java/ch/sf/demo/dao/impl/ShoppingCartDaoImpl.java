package ch.sf.demo.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ch.sf.demo.dao.ShoppingCartDao;
import ch.sf.demo.model.ShoppingCart;

@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public ShoppingCart getById(Long id){
		return em.find(ShoppingCart.class, id);
	}
	
	@Transactional
	public void insert(ShoppingCart sc){
		em.persist(sc);
		em.flush();
	}

}
