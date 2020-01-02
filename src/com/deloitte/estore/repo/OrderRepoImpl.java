package com.deloitte.estore.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.deloitte.estore.model.Order;

public class OrderRepoImpl implements OrderRepo {
	private Connection getDBConnection() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.7:1521:xe", "system", "admin");
		return con;
	}

	@Override
	public boolean addOrder(Order Order) throws SQLException {
		return false;
	}
	@Override
	public boolean deleteOrder(Order Order) throws SQLException {
		return false;
	}

	@Override
	public boolean updateOrder(Order Order) throws SQLException {
		return false;
	}

	@Override
	public Order getOrderById(int orderId) throws SQLException {
		return null;
	}

	@Override
	public List<Order> getAllOrders() throws SQLException {
		return null;
	}

}