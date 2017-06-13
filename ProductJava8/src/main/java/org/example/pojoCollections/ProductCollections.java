package org.example.pojoCollections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.example.pojo.Product;

public class ProductCollections {

	private static final Logger log = Logger.getLogger(ProductCollections.class);

	private ArrayList<Product> prodCollection = new ArrayList<>();

	private Stream<Product> products() {
		return getAllProduct().stream();
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

	public void setProd(ArrayList<Product> prodCollection) {
		this.prodCollection = prodCollection;
	}

	public ArrayList<Product> getAllProduct() {
		if (getProd().isEmpty()) {
			getProd().add(new Product().setName("Икра красная \"Вкуснота \"").setBrand("Белорусская традиция").setPrice(25));
			getProd().add(new Product().setName("Чай зеленый \"Принцесса Нури\"").setBrand("Ахмад").setPrice(15));
			getProd().add(new Product().setName("Чай ароматный с бергамотом.").setBrand("Беседа").setPrice(1000));
			getProd().add(new Product().setName("Чай ароматный с бергамотом.").setBrand("Беседа").setPrice(65));
			getProd().add(new Product().setName("Lipton Yellow Label").setBrand("Lipton").setPrice(50));
			getProd().add(new Product().setName("Magic aroma").setBrand("Lipton").setPrice(18));
			getProd().add(new Product().setName("English Breakfast").setBrand("Lipton").setPrice(12));
			getProd().add(new Product().setName("Royal Ceylon").setBrand("Lipton").setPrice(14));
		}

		return prodCollection;
	}
	
	public ArrayList<Product> getProd() {
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
			log.info("Dont find element. ");
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

}
