package org.example.main;

import org.apache.log4j.Logger;
import org.example.pojoCollections.ProductCollections;
import static org.example.pojoCollections.ProductCollections.productBrand;
import static org.example.pojoCollections.ProductCollections.productName;
import static org.example.pojoCollections.ProductCollections.productPrice;

public class MainClasss {
	
	private static final Logger log = Logger.getLogger(MainClasss.class);
		
	public static void main(String[] args) {
		ProductCollections pc = new ProductCollections();	
		
		log.info(pc.prodWithMaxPrice()); 
		log.info(pc.prodWithMinPrice());
		
		log.info("=========================");
		
		log.info(pc.findBy(productBrand("Беседа")));
		log.info(pc.findBy(productName("Ceylon")));
		log.info(pc.findBy(productPrice(50)));
	}

}
