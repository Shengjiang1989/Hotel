package edu.neu.cs5200.hotel.test.service;

import java.util.Date;

import edu.neu.cs5200.hotel.main.request.CreateCustomerReq;
import edu.neu.cs5200.hotel.main.service.RegisterCustomer;

public class CRUNCustomer {

	public static void main(String[] args) {
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
