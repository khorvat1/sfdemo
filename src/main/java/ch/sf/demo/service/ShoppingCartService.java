package ch.sf.demo.service;

import ch.sf.demo.xml.Inventory;

public interface ShoppingCartService {
	
	/**
	 * Create shopping cart from file on given relative path
	 * @throws Exception
	 */
	public void createShoppingCartFromFileData(String relativePath) throws Exception;
	
	/**
	 * Create and persist shopping cart with given inventory
	 * @param inventory Items to put in shopping cart
	 * @throws Exception
	 */
	public void createShopingCart(Inventory inventory) throws Exception;

}
