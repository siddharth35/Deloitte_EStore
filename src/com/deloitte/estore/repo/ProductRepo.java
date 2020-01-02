package com.deloitte.estore.repo;

import java.sql.SQLException;
import java.util.List;

import com.deloitte.estore.model.Product;

public interface ProductRepo {
	boolean addProduct(Product product) throws SQLException;
	boolean deleteProduct(Product product) throws SQLException;
	boolean updateProduct(Product product) throws SQLException;
	Product getProductById(int productId) throws SQLException;
	List<Product> getAllProducts() throws SQLException;
}
