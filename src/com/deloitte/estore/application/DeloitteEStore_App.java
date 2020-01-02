package com.deloitte.estore.application;


import com.deloitte.estore.model.Product;
import com.deloitte.estore.service.ProductService;
import com.deloitte.estore.service.ProductServiceImpl;

public class DeloitteEStore_App {
	public static void main(String[] args) {
		ProductService service = new ProductServiceImpl();
		Product p = new Product(1011, "MobilePhone", 40000);
		try {
			if(service.addProduct(p)) {
				System.out.println("Product Added Successfully\nDetails: "+p);
			} else {
				System.out.println("Product Not Added");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
