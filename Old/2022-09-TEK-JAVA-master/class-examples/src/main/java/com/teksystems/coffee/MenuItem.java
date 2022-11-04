package com.teksystems.coffee;

public class MenuItem {

	private String item;
	private String type;
	private Double price;


	public MenuItem(String item, String type, Double price) {
		this.item = item;
		this.type = type;
		this.price = price;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "menuitem { item name = " + getItem() + ", type = " + getType() + ", price = " + getPrice() + "}";
	}

}
