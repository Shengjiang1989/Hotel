package edu.neu.cs5200.hotel.main.dao;

import edu.neu.cs5200.hotel.main.basedao.BaseDAO;
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

	public Hoteluser getHoteluserById(int hotelUserId) {
		// TODO Auto-generated method stub
		return baseDAO.getById(Hoteluser.class, hotelUserId);
	}

}
