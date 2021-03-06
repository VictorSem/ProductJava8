package org.example.pojoCollections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.example.pojo.Product;

public class ProductCollection {

	private static final Logger log = Logger.getLogger(ProductCollection.class);

	private ArrayList<Product> prodCollection = new ArrayList<>();

	public Stream<Product> products() {
		return getProdCollection().stream();
	}

	public int size() {
		return prodCollection.size();
	}

	public Product get(int i) {
		return prodCollection.get(i);
	}

	public boolean isEmpty() { 
		return prodCollection.isEmpty();
	}

	public ArrayList<Product> getProdCollection() {
		if (isEmpty()) {
			prodCollection.add(new Product().setName("Икра красная \"Вкуснота \"").setBrand("Наши традиции").setPrice(25));
			prodCollection.add(new Product().setName("Чай зеленый \"Принцесса Нури\"").setBrand("Ахмад").setPrice(15));
			prodCollection.add(new Product().setName("Чай ароматный с бергамотом.").setBrand("Беседа").setPrice(140));
			prodCollection.add(new Product().setName("Чай ароматный с бергамотом.").setBrand("Беседа").setPrice(65));
			prodCollection.add(new Product().setName("Lipton Yellow Label").setBrand("Lipton").setPrice(50));
			prodCollection.add(new Product().setName("Magic aroma").setBrand("Lipton").setPrice(18));
			prodCollection.add(new Product().setName("English Breakfast").setBrand("Lipton").setPrice(12));
			prodCollection.add(new Product().setName("Royal Ceylon").setBrand("Lipton").setPrice(14));
		}

		return prodCollection;
	}
	
	

	@Override
	public String toString() {
		return "ProductCollections [prodCollection=" + prodCollection + "]";
	}

	public List<Product> sortByName() {
		return products().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
	}

	public List<Product> sortByPrice() {
		return products().sorted(Comparator.comparingInt(Product::getPrice)).collect(Collectors.toList());

	}

	public Product prodWithMaxPrice() {
		return products().max(Comparator.comparing(Product::getPrice)).get();
	}

	public Product prodWithMinPrice() {
		return products().min(Comparator.comparingInt(Product::getPrice)).get();
	}

	public List<Product> findBy(Predicate<Product> predicate) {
		List<Product> list = products().filter(predicate)
				.collect(Collectors.toList());

		if (list.isEmpty()) {
			log.info("Dont find element.  ");
		}
		return list;
	}
	
	
	public static Predicate<Product> productName(String productName) {
		return p -> p.getName().contains(productName);
	}
	
	public static Predicate<Product> productBrand(String productBrand) {
		return p -> p.getBrand().contains(productBrand);
	}
	
	public static Predicate<Product> productPrice(Integer productPrice) {
		return p -> p.getPrice().equals(productPrice);
	}
	
	
	
	public boolean isAnyProductPriceGreaterOrEqual(Integer productPrice) {
		return products().anyMatch(p -> p.getPrice() >= productPrice);
	}
	
	public boolean isNoneProductPriceGreaterOrEqual(Integer productPrice) {
		return products().noneMatch(p -> p.getPrice() >= productPrice);
	}
	
	public boolean isAllProductPriceGreaterOrEqual(Integer productPrice) {
		return products().allMatch(p -> p.getPrice() >= productPrice);
	}

}
