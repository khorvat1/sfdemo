package ch.sf.demo.dao;

import ch.sf.demo.model.Item;

public interface ItemDao {
	
	/**
	 * Get single item by id
	 * @param id Item id
	 * @return
	 */
	public Item getById(Long id);
	
	/**
	 * Get single item by code two (nummer2)
	 * @param code Item code (nummer2)
	 * @return 
	 */
	public Item getByCodeTwo(String code);

}
