package ch.sf.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.sf.demo.dao.ItemDao;
import ch.sf.demo.dao.ShoppingCartDao;
import ch.sf.demo.model.Item;
import ch.sf.demo.model.ShoppingCart;
import ch.sf.demo.model.ShoppingCartDetails;
import ch.sf.demo.service.ShoppingCartService;
import ch.sf.demo.service.XmlReaderService;
import ch.sf.demo.xml.Inventory;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	final static Logger log = Logger.getLogger(ShoppingCartServiceImpl.class);

	@Autowired
	private XmlReaderService xmlReaderService;

	@Autowired
	private ItemDao itemDao;

	@Autowired
	private ShoppingCartDao shoppingCartDao;

	@Transactional(rollbackFor = java.lang.Exception.class)
	public void createShoppingCartFromFileData(String relativePath) throws Exception {

		Inventory inventory = this.xmlReaderService.readXmlStructure(relativePath);

		if (inventory != null) {
			this.createShopingCart(inventory);
		} else {
			throw new Exception("No shopping cart items");
		}

	}

	@Transactional(rollbackFor = java.lang.Exception.class)
	public void createShopingCart(Inventory inventory) throws Exception {

		try {
			ShoppingCart sc = new ShoppingCart();
			List<ShoppingCartDetails> scdList = new ArrayList<ShoppingCartDetails>();

			for (ch.sf.demo.xml.Item i : inventory.getItems()) {
				Item dbItem = this.itemDao.getByCodeTwo(i.getValueZero().getValue().toString());
				if (dbItem == null) {
					throw new Exception("No data for xml value0");
				}

				ShoppingCartDetails scd = new ShoppingCartDetails();
				scd.setItemCustomized(dbItem);
				scd.setQuantity(i.getValueTwo().getValue().longValue());
				scd.setShopingCart(sc);
				scdList.add(scd);
			}

			sc.setDetails(scdList);
			shoppingCartDao.insert(sc);
			
		} catch (ConstraintViolationException e) {
			Set<ConstraintViolation<?>> errors = e.getConstraintViolations();
			for (Object o : errors) {
				log.error(o.toString());
			}
			throw e;
		}

	}

}
