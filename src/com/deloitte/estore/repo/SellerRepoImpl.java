package com.deloitte.estore.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.deloitte.estore.model.Seller;

public class SellerRepoImpl implements SellerRepo {
	private Connection getDBConnection() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.7:1521:xe", "system", "admin");
		return con;
	}
	@Override
	public boolean addSeller(Seller seller) throws SQLException {
		Connection con = getDBConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO SELLER VALUES(?,?,?)");
		ps.setInt(1, seller.getSellerId());
		ps.setString(2, seller.getName());
		ps.setString(3, seller.getLocation());
		return ps.executeUpdate() > 0;
	}

	@Override
	public boolean deleteSeller(Seller seller) throws SQLException {
		Connection con = getDBConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM SELLER WHERE SELLER_ID=?");
		ps.setInt(1, seller.getSellerId());
		return ps.executeUpdate() > 0;
	}

	@Override
	public boolean updateSeller(Seller seller) throws SQLException {
		Connection con = getDBConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE SELLER SET SELLER_NAME=?, SELLER_LOC=? WHERE SELLER_ID=?");
		ps.setString(1, seller.getName());
		ps.setString(2, seller.getLocation());
		ps.setInt(3, seller.getSellerId());
		return ps.executeUpdate() > 0;
	}

	@Override
	public Seller getSellerById(int sellerId) throws SQLException {
		Connection con = getDBConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM SELLER WHERE SELLER_ID=?");
		ps.setInt(1, sellerId);
		ResultSet rs = ps.executeQuery();
		Seller s = new Seller();
		s.setSellerId(rs.getInt(rs.findColumn("SELLER_ID")));
		s.setName(rs.getString(rs.findColumn("SELLER_NAME")));
		s.setLocation(rs.getString(rs.findColumn("SELLER_LOC")));
		return s;
	}

	@Override
	public List<Seller> getAllSellers() throws SQLException {
		Connection con = getDBConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM SELLER");
		ResultSet rs = ps.executeQuery();
		List<Seller> slist = new ArrayList<>();
		while(rs.next()) {
			Seller s = new Seller();
			s.setSellerId(rs.getInt(rs.findColumn("SELLER_ID")));
			s.setName(rs.getString(rs.findColumn("SELLER_NAME")));
			s.setLocation(rs.getString(rs.findColumn("SELLER_LOC")));
			slist.add(s);
		}
		return slist;
	}

}
