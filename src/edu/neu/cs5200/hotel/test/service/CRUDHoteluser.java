package edu.neu.cs5200.hotel.test.service;

import java.util.Date;

import edu.neu.cs5200.hotel.main.request.CreateHotelUserReq;
import edu.neu.cs5200.hotel.main.service.RegisterHotelUser;

public class CRUDHoteluser {
	
	public static void main(String[] args) {
		CreateHotelUserReq createHotelUserReq = new CreateHotelUserReq();
		createHotelUserReq.setUsername("LongWoodHotel");
		createHotelUserReq.setPassword("longwood1999");
		createHotelUserReq.setRegDate(new Date(System.currentTimeMillis()));
		createHotelUserReq.setSsn("361100");
		
		RegisterHotelUser registerHotelUser = new RegisterHotelUser();
		registerHotelUser.registerHotelUser(createHotelUserReq);
	}

}
