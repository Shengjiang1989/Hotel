package edu.neu.cs5200.hotel.test.service;

//import java.util.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.neu.cs5200.hotel.main.dao.CustomerDAO;
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
		CustomerDAO dao=new CustomerDAO();
		dao.createCustomer(customer);
//		ums.deleteCustomer(customer );
		Customer customers = dao.readCustomerByUsernameAndPassword("Jue","12345");
		List <Customer> cus=new ArrayList<Customer>();
		cus.add(customers);
		System.out.println(cus.size());
		System.out.println(customer.getFirstName());
		
	}
}
