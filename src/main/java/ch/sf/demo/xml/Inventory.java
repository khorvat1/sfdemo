package ch.sf.demo.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Provided xml document root element
 * 
 * @author Kresimir Horvat
 *
 */
@XmlRootElement(name="inventory")
public class Inventory {
	
	@XmlElementWrapper(name="template")
    @XmlElement(name="field", required=false)
    private List<Object> fields;
	
	
    private List<Item> items;

	@XmlElementWrapper(name="items")
    @XmlElement(name="item")
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}
