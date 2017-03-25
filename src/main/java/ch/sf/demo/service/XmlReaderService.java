package ch.sf.demo.service;

import javax.xml.bind.JAXBException;

import ch.sf.demo.xml.Inventory;

public interface XmlReaderService {
	
	/**
	 * Read xml structure of given document to POJO
	 * @param relativePath xml file on classpath
	 * @return Inventory object with all needed xml elements and values
	 * @throws JAXBException
	 */
	public Inventory readXmlStructure(String relativePath) throws JAXBException;

}
