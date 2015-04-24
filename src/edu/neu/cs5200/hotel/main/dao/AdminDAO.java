package edu.neu.cs5200.hotel.main.dao;

import java.util.ArrayList;
import java.util.List;

import edu.neu.cs5200.hotel.main.basedao.BaseDAO;
import edu.neu.cs5200.hotel.main.entity.Admin;
import edu.neu.cs5200.hotel.main.entity.Customer;

public class AdminDAO {
	
	private BaseDAO<Admin> baseDAO;
	
	public AdminDAO(){
		super();
		this.baseDAO = new BaseDAO<Admin>();
	}

	public void createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		baseDAO.create(admin);
	}
	public Admin readAdminByUsernameAndPassword(String username,
			String password) {
		// TODO Auto-generated method stub
		String scope = "SELECT c FROM Admin c WHERE c.username = :username AND c.password = :password";
		ArrayList<String> paras = new ArrayList<String>();
		paras.add(username);
		paras.add(password);
		ArrayList<String> paramName = new ArrayList<String>();
		paramName.add("username");
		paramName.add("password");
		List<Admin> admins = new ArrayList<Admin>();
		admins = baseDAO.query(scope, paramName, paras);
		if (admins.size() > 0)
			return admins.get(0);
		return null;
	}

}
