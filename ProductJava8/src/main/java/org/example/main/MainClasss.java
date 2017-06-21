package org.example.main;

import static org.example.pojoCollections.ProductCollection.productBrand;
import static org.example.pojoCollections.ProductCollection.productName;
import static org.example.pojoCollections.ProductCollection.productPrice;

import org.apache.log4j.Logger;
import org.example.pojoCollections.ProductCollection;

public class MainClasss {

	private static final Logger log = Logger.getLogger(MainClasss.class);

	public static void main(String[] args) {
		ProductCollection pc = new ProductCollection();

		log.info(pc.prodWithMaxPrice());
		log.info(pc.prodWithMinPrice());

		log.info("=========================");

		log.info(pc.findBy(productBrand("Беседа")));
		log.info(pc.findBy(productName("Ceylon")));
		log.info(pc.findBy(productPrice(50)));
		
		
		log.info("=========================");
		
		log.info(pc.isAnyProductPriceGreaterOrEqual(100)); //true
		log.info(pc.isNoneProductPriceGreaterOrEqual(200)); //true
		log.info(pc.isAllProductPriceGreaterOrEqual(100)); //false
		
		

		
	}

}
