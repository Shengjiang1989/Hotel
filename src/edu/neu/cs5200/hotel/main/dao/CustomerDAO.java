package edu.neu.cs5200.hotel.main.dao;

import java.util.ArrayList;
import java.util.List;

import edu.neu.cs5200.hotel.main.basedao.BaseDAO;
import edu.neu.cs5200.hotel.main.entity.Customer;

public class CustomerDAO {

	private BaseDAO<Customer> baseDAO;
	
	public CustomerDAO(){
		super();
		this.baseDAO = new BaseDAO<Customer>();
	}
	
	public void createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		baseDAO.create(customer);
	}
	
	public Customer readCustomerById(Integer id) {
		return baseDAO.getById(Customer.class, id);
	}

	public Customer readCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		String scope = "SELECT c FROM Customer c WHERE c.username = :username";
		ArrayList<String> paras = new ArrayList<String>();
		paras.add(username);
		ArrayList<String> paramName = new ArrayList<String>();
		paramName.add("username");
		List<Customer> customers = new ArrayList<Customer>();
		customers = baseDAO.query(scope, paramName, paras);
		if (customers.size() > 0)
			return customers.get(0);
		return null;
	}

	public Customer readCustomerByUsernameAndPassword(String username,
			String password) {
		// TODO Auto-generated method stub
		String scope = "SELECT c FROM Customer c WHERE c.username = :username AND c.password = :password";
		ArrayList<String> paras = new ArrayList<String>();
		paras.add(username);
		paras.add(password);
		ArrayList<String> paramName = new ArrayList<String>();
		paramName.add("username");
		paramName.add("password");
		List<Customer> customers = new ArrayList<Customer>();
		customers = baseDAO.query(scope, paramName, paras);
		if (customers.size() > 0)
			return customers.get(0);
		return null;
	}

}
