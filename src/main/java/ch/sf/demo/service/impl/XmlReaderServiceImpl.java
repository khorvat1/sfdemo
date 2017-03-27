package ch.sf.demo.service.impl;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import ch.sf.demo.service.XmlReaderService;
import ch.sf.demo.xml.Inventory;

@Service
public class XmlReaderServiceImpl implements XmlReaderService {

	final static Logger log = Logger.getLogger(XmlReaderServiceImpl.class);

	public Inventory readXmlStructure(String relativePath) throws Exception {
		try {
			JAXBContext jc = JAXBContext.newInstance(Inventory.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();

			// log for unmarshaller
			unmarshaller.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());

			Inventory inventory = (Inventory) unmarshaller.unmarshal(new File(this.getClass().getResource(relativePath).getPath()));

			return inventory;

		} catch (Exception e) {
			log.error("Error while parsing xml input", e);
			throw e;
		}
	}

}
