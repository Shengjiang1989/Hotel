package edu.neu.cs5200.hotel.test.service;

//import java.util.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.neu.cs5200.hotel.main.entity.Customer;
import edu.neu.cs5200.hotel.main.service.UserManagementService;

public class UserManagementServiceTest {

	public static void main(String[] args) {
		UserManagementService ums = new UserManagementService();
		Customer customer = new Customer();
		customer.setId(1);
		customer.setFirstName("grEEN");
		customer.setLastName("Red");
		customer.setPassword("12345");
		String str_date="2015-04-08";
		DateFormat formatter ; 
		Date date = new Date(); 
		   formatter = new SimpleDateFormat("yyyy-MM-dd");
		   try {
			date = formatter.parse(str_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customer.setRegDate(date);
		customer.setTelephone("556-789-000");
		customer.setUsername("Jue");
		ums.deleteCustomer(customer );
	}
}
