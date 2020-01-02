package com.deloitte.estore.repo;

import java.sql.SQLException;
import java.util.List;

import com.deloitte.estore.model.Order;

public interface OrderRepo {
	boolean addOrder(Order Order) throws SQLException;
	boolean deleteOrder(Order Order) throws SQLException;
	boolean updateOrder(Order Order) throws SQLException;
	Order getOrderById(int orderId) throws SQLException;
	List<Order> getAllOrders() throws SQLException;
}
