package com.deloitte.estore.repo;

import java.sql.SQLException;
import java.util.List;

import com.deloitte.estore.model.Seller;

public interface SellerRepo {
	boolean addSeller(Seller seller) throws SQLException;
	boolean deleteSeller(Seller seller) throws SQLException;
	boolean updateSeller(Seller seller) throws SQLException;
	Seller getSellerById(int sellerId) throws SQLException;
	List<Seller> getAllSellers() throws SQLException;
}
