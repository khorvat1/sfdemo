package ch.sf.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class for database object fs_shop.artikel
 * 
 * @author Kresimir Horvat
 *
 */
@Entity
@Table(name="fs_shop.artikel")
public class Item {
	
	@Id
	private Long id;
	
	@Column(name="BEZEICHNUNG1")
	private String designationOne;
	
	@Column(name="BEZEICHNUNG2")
	private String designationTwo;
	
	@Column(name="nummer1")
	private String numberOne;
	
	@Column(name="nummer2")
	private String numberTwo;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getNumberOne() {
		return numberOne;
	}

	public void setNumberOne(String numberOne) {
		this.numberOne = numberOne;
	}

	public String getNumberTwo() {
		return numberTwo;
	}

	public void setNumberTwo(String numberTwo) {
		this.numberTwo = numberTwo;
	}
}
