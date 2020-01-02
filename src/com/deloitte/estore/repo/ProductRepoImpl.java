package com.deloitte.estore.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.deloitte.estore.model.Product;

public class ProductRepoImpl implements ProductRepo{
	private Connection getDBConnection() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.7:1521:xe", "system", "admin");
		return con;
	}

	@Override
	public boolean addProduct(Product product) throws SQLException {
		Connection con = getDBConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO PRODUCT VALUES(?,?,?)");
		ps.setInt(1, product.getProductId());
		ps.setString(2, product.getName());
		ps.setDouble(3, product.getPrice());
		return ps.executeUpdate() > 0;
	}

	@Override
	public boolean deleteProduct(Product product) throws SQLException {
		Connection con = getDBConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM PRODUCT WHERE PRODUCT_ID=?");
		ps.setInt(1, product.getProductId());
		return ps.executeUpdate() > 0;
	}

	@Override
	public boolean updateProduct(Product product) throws SQLException {
		Connection con = getDBConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE PRODUCT SET PRODUCT_NAME=?, PRODUCT_PRICE=? WHERE PRODUCT_ID=?");
		ps.setString(1, product.getName());
		ps.setDouble(2, product.getPrice());
		ps.setInt(3, product.getProductId());
		return ps.executeUpdate() > 0;
	}

	@Override
	public Product getProductById(int productId) throws SQLException {
		Connection con = getDBConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM PRODUCT WHERE PRODUCT_ID=?");
		ps.setInt(1, productId);
		ResultSet rs = ps.executeQuery();
		Product p = new Product();
		p.setProductId(rs.getInt(rs.findColumn("PRODUCT_ID")));
		p.setName(rs.getString(rs.findColumn("PRODUCT_NAME")));
		p.setPrice(rs.getDouble(rs.findColumn("PRODUCT_PRICE")));
		return p;
	}

	@Override
	public List<Product> getAllProducts() throws SQLException {
		Connection con = getDBConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM PRODUCT");
		ResultSet rs = ps.executeQuery();
		List<Product> plist = new ArrayList<>();
		while(rs.next()) {
			Product p = new Product();
			p.setProductId(rs.getInt(rs.findColumn("PRODUCT_ID")));
			p.setName(rs.getString(rs.findColumn("PRODUCT_NAME")));
			p.setPrice(rs.getDouble(rs.findColumn("PRODUCT_PRICE")));
			plist.add(p);
		}
		return plist;
	}
}
