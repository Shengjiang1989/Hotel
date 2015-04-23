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
	
	public List<Customer> getAllCustomer() {
		String scope = "SELECT s FROM Customer s";
		return baseDAO.query(scope, null, null);
	}
	
	/**
	 * Persist a customer into database
	 * @param customer -- Customer
	 */
	public void createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		baseDAO.create(customer);
	}
	
	/**
	 * Retrieve a customer from database by its primary key id
	 * @param id -- Primary key id of a customer
	 * @return -- Customer with the id
	 */
	public Customer readCustomerById(Integer id) {
		return baseDAO.getById(Customer.class, id);
	}

	/**
	 * Retrieve customer from database by its username
	 * @param username -- Username of customer
	 * @return -- Customer with the username. 
	 * If there are multiple customers with same username, only return the first one.
	 */
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

	/**
	 * Retrieve customer by its username and password
	 * @param username -- Username of customer
	 * @param password -- Password of customer
	 * @return -- Customer with the username and the password. 
	 * If there are multiple customers with same username and password, 
	 * only return the first one.
	 */
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

	public void deleteCustomerByUsername(Customer customer) {
		// TODO Auto-generated method stub
		customer = baseDAO.getById(Customer.class, customer.getId());
		baseDAO.delete(customer);
	}

	public Customer getCustomerByUsername(String username) {
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

	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		return baseDAO.update(customer);
	}

}
