package edu.neu.cs5200.hotel.test.service;

import edu.neu.cs5200.hotel.main.request.CreateAdminReq;
import edu.neu.cs5200.hotel.main.service.RegisterAdmin;

public class CRUDAdmin {

	public static void main(String[] args) {
		CreateAdminReq createAdminReq = new CreateAdminReq();
		createAdminReq.setPassword("wwwe817");
		createAdminReq.setSponsoraccount("neu");
		createAdminReq.setUsername("AdminNo1");
		
		RegisterAdmin registerAdmin = new RegisterAdmin();
		registerAdmin.createAdmin(createAdminReq);
	}
}
