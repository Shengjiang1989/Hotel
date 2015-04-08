package edu.neu.cs5200.hotel.main.service;

import edu.neu.cs5200.hotel.main.dao.CustomerDAO;
import edu.neu.cs5200.hotel.main.entity.Customer;

public class ViewCustomerProfile {
	
	public Customer viewCustomerProfileById(Integer id) {
		CustomerDAO customerDAO = new CustomerDAO();
		return customerDAO.readCustomerById(id);
	}
	
	public Customer viewCustomerProfileByUsername(String username) {
		CustomerDAO customerDAO = new CustomerDAO();
		return customerDAO.readCustomerByUsername(username);
	}

	public Boolean verifyCustomer(String username, String password) {
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = customerDAO.readCustomerByUsernameAndPassword(username, password);
		if (customer != null) return true;
		return false;
	}
}
