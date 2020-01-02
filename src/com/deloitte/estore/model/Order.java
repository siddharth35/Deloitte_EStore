package com.deloitte.estore.model;

public class Order {
	private int orderId;
	private Product product;
	private Customer customer;
	private Seller seller;
	public Order(int orderId, Product product, Customer customer, Seller seller) {
		super();
		this.orderId = orderId;
		this.product = product;
		this.customer = customer;
		this.seller = seller;
	}
	public Order() {
		super();
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
}
