package edu.neu.cs5200.hotel.main.service;

import java.util.List;

import edu.neu.cs5200.hotel.main.dao.AdminDAO;
import edu.neu.cs5200.hotel.main.dao.CustomerDAO;
import edu.neu.cs5200.hotel.main.dao.HoteluserDAO;
import edu.neu.cs5200.hotel.main.entity.Admin;
import edu.neu.cs5200.hotel.main.entity.Customer;
import edu.neu.cs5200.hotel.main.entity.Hoteluser;
import edu.neu.cs5200.hotel.main.request.CreateAdminReq;
import edu.neu.cs5200.hotel.main.request.CreateCustomerReq;
import edu.neu.cs5200.hotel.main.request.CreateHotelUserReq;

public class UserManagementService {

	/**
	 * Create a new customer in system
	 * 
	 * @param createCustomerReq
	 *            -- Create a new customer request
	 */
	public List<Customer> createCustomer(CreateCustomerReq createCustomerReq) {
		Customer customer = new Customer();
		customer.setFirstName(createCustomerReq.getFirstName());
		customer.setLastName(createCustomerReq.getLastName());
		customer.setTelephone(createCustomerReq.getTelephone());
		customer.setRegDate(createCustomerReq.getRegDate());
		customer.setUsername(createCustomerReq.getUsername());
		customer.setPassword(createCustomerReq.getPassword());

		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.createCustomer(customer);
		return customerDAO.getAllCustomer();
	}

	public List<Customer> deleteCustomer(Customer customer) {
		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.deleteCustomerByUsername(customer);
		return customerDAO.getAllCustomer();
	}

	public Customer getCustomerByUsername(String username) {
		CustomerDAO customerDAO = new CustomerDAO();
		return customerDAO.getCustomerByUsername(username);
	}

	public Boolean verifyCustomer(String username, String password) {
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = customerDAO.readCustomerByUsernameAndPassword(
				username, password);
		if (customer != null)
			return true;
		else
			return false;
	}
	public Boolean verifyHoteluser(String username, String password) {
		HoteluserDAO hoteluserDAO = new HoteluserDAO();
		Hoteluser hoteluser = hoteluserDAO.readHoteluserByUsernameAndPassword(
				username, password);
		if (hoteluser != null)
			return true;
		else
			return false;
	}

	public List<Customer> updateCustomer(Customer customer) {
		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.updateCustomer(customer);
		return customerDAO.getAllCustomer();
	}

	public void createAdmin(CreateAdminReq createAdminReq) {
		Admin admin = new Admin();
		admin.setPassword(createAdminReq.getPassword());
		admin.setSponsorAccount(createAdminReq.getSponsoraccount());
		admin.setUsername(createAdminReq.getUsername());

		AdminDAO adminDAO = new AdminDAO();
		adminDAO.createAdmin(admin);
	}

	public void createHotelUser(CreateHotelUserReq createHotelUserReq) {
		Hoteluser hoteluser = new Hoteluser();
		hoteluser.setPassword(createHotelUserReq.getPassword());
		hoteluser.setRegDate(createHotelUserReq.getRegDate());
		hoteluser.setSsn(createHotelUserReq.getSsn());
		hoteluser.setUsername(createHotelUserReq.getUsername());

		HoteluserDAO hoteluserDAO = new HoteluserDAO();
		hoteluserDAO.createHoteluser(hoteluser);
	}
	
	public Hoteluser getHoteluserById(int hotelUserId) {
		HoteluserDAO hoteluserDAO = new HoteluserDAO();
		return hoteluserDAO.getHoteluserById(hotelUserId);
	}
	
	public Boolean verifyUser(String email, String password) {
		if(email.equals("yangjue1031@foxmail.com") && password.equals("aa"))
		return true;
		else 
			return false;
	}
}
