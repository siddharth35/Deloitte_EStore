package com.deloitte.estore.service;

import java.sql.SQLException;
import java.util.List;

import com.deloitte.estore.model.Product;
import com.deloitte.estore.repo.ProductRepo;
import com.deloitte.estore.repo.ProductRepoImpl;
import com.deloitte.estore.util.InvalidNameException;

public class ProductServiceImpl implements ProductService {
	private ProductRepo pRepo;
	
	public ProductServiceImpl() {
		super();
		pRepo = new ProductRepoImpl();
	}

	public ProductServiceImpl(ProductRepo pRepo) {
		super();
		this.pRepo = pRepo;
	}

	@Override
	public boolean addProduct(Product product) throws SQLException, InvalidNameException {
		if(product.getName().length()>3) {
			pRepo.addProduct(product);
		} else {
			throw new InvalidNameException("Name lesser than 3 Character");
		}
		return false;
	}

	@Override
	public boolean deleteProduct(Product product) throws SQLException {
		return false;
	}

	@Override
	public boolean updateProduct(Product product) throws SQLException {
		return false;
	}

	@Override
	public Product getProductById(int productId) throws SQLException {
		return null;
	}

	@Override
	public List<Product> getAllProducts() throws SQLException {
		return null;
	}

}
