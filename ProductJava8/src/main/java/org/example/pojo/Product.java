package org.example.pojo;

public class Product {
	
	private String name;
	private Integer price;	
	private String brand;
		
	
	
	public Integer getPrice() {
		return price;
	}

	public Product setPrice(Integer price) {
		this.price = price;
		return this;
	}
	
	public String getName() {
		return name;
	}
	public Product setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getBrand() {
		return brand;
	}
	public Product setBrand(String brand) {
		this.brand = brand;
		return this;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", brand=" + brand + "]";
	}
	
	
	
}
