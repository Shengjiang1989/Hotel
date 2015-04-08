package edu.neu.cs5200.hotel.main.dao;

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

}
