package com.deloitte.estore.service;

import java.sql.SQLException;
import java.util.List;

import com.deloitte.estore.model.Product;
import com.deloitte.estore.util.InvalidNameException;

public interface ProductService {
	boolean addProduct(Product product) throws SQLException, InvalidNameException;
	boolean deleteProduct(Product product) throws SQLException;
	boolean updateProduct(Product product) throws SQLException;
	Product getProductById(int productId) throws SQLException;
	List<Product> getAllProducts() throws SQLException;
}
