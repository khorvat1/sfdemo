package ch.sf.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity class for database object fs_shop.warenkorbkoepfe
 * 
 * @author Kresimir Horvat
 *
 */
@Entity
@Table(name = "fs_shop.warenkorbkoepfe")
public class ShoppingCart {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="Objekt_ID")
	private Long objectId = 1L;

	@OneToMany(mappedBy = "shopingCart", cascade = CascadeType.ALL)
	private List<ShoppingCartDetails> details;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ShoppingCartDetails> getDetails() {
		return details;
	}

	public void setDetails(List<ShoppingCartDetails> details) {
		this.details = details;
	}

}
