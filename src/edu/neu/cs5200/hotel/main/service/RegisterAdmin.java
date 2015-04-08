package edu.neu.cs5200.hotel.main.service;

import edu.neu.cs5200.hotel.main.dao.AdminDAO;
import edu.neu.cs5200.hotel.main.entity.Admin;
import edu.neu.cs5200.hotel.main.request.CreateAdminReq;


public class RegisterAdmin {
	public void createAdmin(CreateAdminReq createAdminReq){
		Admin admin = new Admin();
		admin.setPassword(createAdminReq.getPassword());
		admin.setSponsorAccount(createAdminReq.getSponsoraccount());
		admin.setUsername(createAdminReq.getUsername());
		
		AdminDAO adminDAO = new AdminDAO();
		adminDAO.createAdmin(admin);
	}
}
