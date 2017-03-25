package ch.sf.demo.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Provided xml document items
 * 
 * @author Kresimir Horvat
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
	
	@XmlAttribute(name="uid")
    private String uid;
	
	@XmlElement(name="value0")
    private Value valueZero;
	
	public Value getValueZero() {
		return valueZero;
	}

	public void setValueZero(Value valueZero) {
		this.valueZero = valueZero;
	}

	public Value getValueTwo() {
		return valueTwo;
	}

	public void setValueTwo(Value valueTwo) {
		this.valueTwo = valueTwo;
	}

	@XmlElement(name="value2")
    private Value valueTwo;
	
	@XmlElement(name="value5", required=false)
    private String valueFive;
	
	@XmlElement(name="value6", required=false)
    private String valueSix;
	
	@XmlElement(name="value7", required=false)
    private String valueSeven;
	
	@XmlElement(name="value8", required=false)
    private String valueEight;
	
	@XmlElement(name="value9", required=false)
    private String valueNine;
	
	
}
