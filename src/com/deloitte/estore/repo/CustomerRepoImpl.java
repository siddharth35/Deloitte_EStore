package com.deloitte.estore.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.deloitte.estore.model.Customer;

public class CustomerRepoImpl implements CustomerRepo {
	private Connection getDBConnection() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.7:1521:xe", "system", "admin");
		return con;
	}
	@Override
	public boolean addCustomer(Customer customer) throws SQLException {
		Connection con = getDBConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO CUSTOMER VALUES(?,?,?)");
		ps.setInt(1, customer.getCustomerId());
		ps.setString(2, customer.getName());
		ps.setString(3, customer.getLocation());
		return ps.executeUpdate() > 0;
	}

	@Override
	public boolean deleteCustomer(Customer customer) throws SQLException {
		Connection con = getDBConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM CUSTOMER WHERE CUSTOMER_ID=?");
		ps.setInt(1, customer.getCustomerId());
		return ps.executeUpdate() > 0;
	}

	@Override
	public boolean updateCustomer(Customer customer) throws SQLException {
		Connection con = getDBConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE CUSTOMER SET CUSTOMER_NAME=?, CUSTOMER_LOC=? WHERE CUSTOMER_ID=?");
		ps.setString(1, customer.getName());
		ps.setString(2, customer.getLocation());
		ps.setInt(3, customer.getCustomerId());
		return ps.executeUpdate() > 0;
	}

	@Override
	public Customer getCustomerById(int customerId) throws SQLException {
		Connection con = getDBConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CUSTOMER WHERE CUSTOMER_ID=?");
		ps.setInt(1, customerId);
		ResultSet rs = ps.executeQuery();
		Customer c = new Customer();
		c.setCustomerId(rs.getInt(rs.findColumn("CUSTOMER_ID")));
		c.setName(rs.getString(rs.findColumn("CUSTOMER_NAME")));
		c.setLocation(rs.getString(rs.findColumn("CUSTOMER_LOC")));
		return c;
	}

	@Override
	public List<Customer> getAllCustomers() throws SQLException {
		Connection con = getDBConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM CUSTOMER");
		ResultSet rs = ps.executeQuery();
		List<Customer> clist = new ArrayList<>();
		while(rs.next()) {
			Customer c = new Customer();
			c.setCustomerId(rs.getInt(rs.findColumn("CUSTOMER_ID")));
			c.setName(rs.getString(rs.findColumn("CUSTOMER_NAME")));
			c.setLocation(rs.getString(rs.findColumn("CUSTOMER_LOC")));
			clist.add(c);
		}
		return clist;
	}

}
