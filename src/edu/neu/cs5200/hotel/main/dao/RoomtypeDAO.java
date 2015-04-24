package edu.neu.cs5200.hotel.main.dao;

import edu.neu.cs5200.hotel.main.basedao.BaseDAO;
import edu.neu.cs5200.hotel.main.entity.Roomtype;

public class RoomtypeDAO {
	private BaseDAO<Roomtype> baseDAO;
	
	public RoomtypeDAO(){
		super();
		this.baseDAO = new BaseDAO<Roomtype>();
	}
	
	public Roomtype getRoomTypeBy(Integer id) {
		return this.baseDAO.getById(Roomtype.class, id);
	}
}
