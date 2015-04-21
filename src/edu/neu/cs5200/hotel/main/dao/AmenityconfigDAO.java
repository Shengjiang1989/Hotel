package edu.neu.cs5200.hotel.main.dao;

import java.util.List;

import edu.neu.cs5200.hotel.main.basedao.BaseDAO;
import edu.neu.cs5200.hotel.main.entity.Amenityconfig;

public class AmenityconfigDAO {
	
private BaseDAO<Amenityconfig> baseDAO;
	
	public AmenityconfigDAO(){
		super();
		this.baseDAO = new BaseDAO<Amenityconfig>();
	}
	public List<Amenityconfig> getAllAmenityconfig() {
		String scope = "SELECT a FROM Amenityconfig a";
		return baseDAO.query(scope, null, null);
	}
}
