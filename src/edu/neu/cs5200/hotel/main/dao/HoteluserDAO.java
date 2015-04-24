package edu.neu.cs5200.hotel.main.dao;

import java.util.ArrayList;
import java.util.List;

import edu.neu.cs5200.hotel.main.basedao.BaseDAO;
import edu.neu.cs5200.hotel.main.entity.Customer;
import edu.neu.cs5200.hotel.main.entity.Hoteluser;

public class HoteluserDAO {

	private BaseDAO<Hoteluser> baseDAO;
	
	public HoteluserDAO(){
		super();
		this.baseDAO = new BaseDAO<Hoteluser>();
	}
	
	public void createHoteluser(Hoteluser hoteluser) {
		// TODO Auto-generated method stub
		baseDAO.create(hoteluser);
	}
	
	public void updateHoteluser(Hoteluser hoteluser) {
		baseDAO.update(hoteluser);
	}

	public Hoteluser getHoteluserById(int hotelUserId) {
		// TODO Auto-generated method stub
		return baseDAO.getById(Hoteluser.class, hotelUserId);
	}
	public Hoteluser readHoteluserByUsernameAndPassword(String username,
			String password) {
		// TODO Auto-generated method stub
		String scope = "SELECT c FROM Hoteluser c WHERE c.username = :username AND c.password = :password";
		ArrayList<String> paras = new ArrayList<String>();
		paras.add(username);
		paras.add(password);
		ArrayList<String> paramName = new ArrayList<String>();
		paramName.add("username");
		paramName.add("password");
		List<Hoteluser> hotelusers = new ArrayList<Hoteluser>();
		hotelusers = baseDAO.query(scope, paramName, paras);
		if (hotelusers.size() > 0)
			return hotelusers.get(0);
		return null;
	}
	
	public List<Hoteluser> readAllHoteluser() {
		String scope = "SELECT h FROM Hoteluser h";
		return this.baseDAO.query(scope, null, null);
	}

}
