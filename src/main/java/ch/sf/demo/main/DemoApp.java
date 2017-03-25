package ch.sf.demo.main;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import ch.sf.demo.service.ShoppingCartService;

@Component
public class DemoApp {
	
	final static Logger log = Logger.getLogger(DemoApp.class);
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	/**
	 * Application main method
	 * @param args
	 */
	public static void main(String[] args) {
		//load spring context
		final ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		
		//get bean of this component
		final DemoApp demoApp = ctx.getBean(DemoApp.class);
		
		String xmlDataFile = "/input_data.xml";
		
		try {
			/*
			 * run business logic 
			 * read xml file
			 * persist data to db
			 */
			demoApp.shoppingCartService.createShoppingCartFromFileData(xmlDataFile);
			
		} catch (Exception e) {
			log.error("Error in shoping cart creation", e);
		}
	}

}
