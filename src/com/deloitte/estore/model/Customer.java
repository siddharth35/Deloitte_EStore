package com.deloitte.estore.model;

public class Customer {
	private int customerId;
	private String name;
	private String location;
	public Customer(int customerId, String name, String location) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.location = location;
	}
	public Customer() {
		super();
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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