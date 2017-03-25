package ch.sf.demo.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * Provided xml document values in item element
 * 
 * @author Kresimir Horvat
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Value {
	
	@XmlAttribute
    private Integer min;
	
	@XmlAttribute
    private Integer max;
	
	@XmlValue
    private Integer value;

	
	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
