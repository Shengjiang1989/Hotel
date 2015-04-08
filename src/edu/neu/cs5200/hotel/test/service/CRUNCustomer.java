package edu.neu.cs5200.hotel.test.service;

import java.util.Date;

import edu.neu.cs5200.hotel.main.entity.Customer;
import edu.neu.cs5200.hotel.main.request.CreateCustomerReq;
import edu.neu.cs5200.hotel.main.service.RegisterCustomer;
import edu.neu.cs5200.hotel.main.service.ViewCustomerProfile;

public class CRUNCustomer {

	public static void main(String[] args) {
		CRUNCustomer cRUNCustomer = new CRUNCustomer();
		//cRUNCustomer.createCustomer();
		cRUNCustomer.retrieveCustomer();
	}
	
	public void retrieveCustomer() {
		ViewCustomerProfile viewCustomerProfile = new ViewCustomerProfile();
		Customer customer = new Customer();
		customer = viewCustomerProfile.viewCustomerProfileById(1);
		System.out.println("---------------------" + customer.getUsername());
		customer = viewCustomerProfile.viewCustomerProfileByUsername("Jue");
		System.out.println("---------------------" + customer.getUsername());
		System.out.println("---------------------" + viewCustomerProfile.verifyCustomer("Jue", "12345"));
	}
	
	public void createCustomer() {
		CreateCustomerReq createCustomerReq = new CreateCustomerReq();
		createCustomerReq.setUsername("Jue");
		createCustomerReq.setLastName("Red");
		createCustomerReq.setFirstName("grEEN");
		createCustomerReq.setPassword("12345");
		createCustomerReq.setRegDate(new Date(System.currentTimeMillis()));
		createCustomerReq.setTelephone("556-789-000");
		
		RegisterCustomer registerCustomer = new RegisterCustomer();
		registerCustomer.createCustomer(createCustomerReq);
	}
}
