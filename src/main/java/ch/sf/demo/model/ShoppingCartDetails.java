package ch.sf.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity class for database object fs_shop.warenkorbdetails
 * 
 * @author Kresimir Horvat
 *
 */
@Entity
@Table(name = "fs_shop.warenkorbdetails")
public class ShoppingCartDetails {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="ARTIKELNUMMER1")
	private String itemNumberOne;
	
	@Column(name="ARTIKELNUMMER2")
	private String itemNumberTwo;
	
	@Column(name="BEZEICHNUNG1")
	private String designationOne;
	
	@Column(name="BEZEICHNUNG2")
	private String designationTwo;
	
	@Column(name="MENGE")
	private Long quantity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WarenkorbKopf_ID")
	private ShoppingCart shopingCart;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Artikel_ID")
	private Item item;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ShoppingCart getShopingCart() {
		return shopingCart;
	}

	public void setShopingCart(ShoppingCart shopingCart) {
		this.shopingCart = shopingCart;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getItemNumberOne() {
		return itemNumberOne;
	}

	public void setItemNumberOne(String itemNumberOne) {
		this.itemNumberOne = itemNumberOne;
	}

	public String getItemNumberTwo() {
		return itemNumberTwo;
	}

	public void setItemNumberTwo(String itemNumberTwo) {
		this.itemNumberTwo = itemNumberTwo;
	}

	public String getDesignationOne() {
		return designationOne;
	}

	public void setDesignationOne(String designationOne) {
		this.designationOne = designationOne;
	}

	public String getDesignationTwo() {
		return designationTwo;
	}

	public void setDesignationTwo(String designationTwo) {
		this.designationTwo = designationTwo;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Set shopping item to shopping cart and copy all needed information
	 * @param item 
	 */
	public void setItemCustomized(Item item){
		if (item != null){
			this.item = item;
			this.itemNumberOne = item.getNumberOne();
			this.itemNumberTwo = item.getNumberTwo();
			this.designationOne = item.getDesignationOne();
			this.designationTwo = item.getDesignationTwo();
		}
	}

}
