package ch.sf.demo.dao;

import ch.sf.demo.model.ShoppingCart;

public interface ShoppingCartDao {

	/**
	 * Get shopping cart by its id
	 * @param id
	 * @return
	 */
	public ShoppingCart getById(Long id);
	
	/**
	 * Insert shopping cart and related shopping cart details
	 * @param sc
	 */
	public void insert(ShoppingCart sc);

}
