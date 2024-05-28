package com.rps.client;

public class Product {
	
	int prod_id;
	String Prod_name;
	int price;
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return Prod_name;
	}
	public void setProd_name(String prod_name) {
		Prod_name = prod_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int  price) {
		this.price = price;
	}
	public Product(int prod_id, String prod_name, int price) {
		super();
		this.prod_id = prod_id;
		Prod_name = prod_name;
		this.price = price;
	}
	public Product() {
		
	}
	@Override
	public String toString() {
		return "Product [prod_id=" + prod_id + ", Prod_name=" + Prod_name + ", price=" + price + "]";
	}
	
	
	
	

}
