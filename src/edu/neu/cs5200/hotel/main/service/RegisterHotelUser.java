package edu.neu.cs5200.hotel.main.service;

import edu.neu.cs5200.hotel.main.dao.HoteluserDAO;
import edu.neu.cs5200.hotel.main.entity.Hoteluser;
import edu.neu.cs5200.hotel.main.request.CreateHotelUserReq;


public class RegisterHotelUser {
	public void registerHotelUser(CreateHotelUserReq createHotelUserReq){
	Hoteluser hoteluser= new Hoteluser();
	hoteluser.setPassword(createHotelUserReq.getPassword());
	hoteluser.setRegDate(createHotelUserReq.getRegDate());
	hoteluser.setSsn(createHotelUserReq.getSsn());
	hoteluser.setUsername(createHotelUserReq.getUsername());
	
	HoteluserDAO hoteluserDAO=new HoteluserDAO();
	hoteluserDAO.createHoteluser(hoteluser);
}
}
