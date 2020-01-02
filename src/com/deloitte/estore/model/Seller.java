package com.deloitte.estore.model;

public class Seller {
	private int sellerId;
	private String name;
	private String location;
	public Seller(int sellerId, String name, String location) {
		super();
		this.sellerId = sellerId;
		this.name = name;
		this.location = location;
	}
	public Seller() {
		super();
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
