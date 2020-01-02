package com.deloitte.estore.repo;

import java.sql.SQLException;
import java.util.List;

import com.deloitte.estore.model.Customer;

public interface CustomerRepo {
	boolean addCustomer(Customer customer) throws SQLException;
	boolean deleteCustomer(Customer customer) throws SQLException;
	boolean updateCustomer(Customer customer) throws SQLException;
	Customer getCustomerById(int customerId) throws SQLException;
	List<Customer> getAllCustomers() throws SQLException;
}
