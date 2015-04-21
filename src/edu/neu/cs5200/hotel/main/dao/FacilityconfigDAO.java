package edu.neu.cs5200.hotel.main.dao;

import java.util.List;

import edu.neu.cs5200.hotel.main.basedao.BaseDAO;
import edu.neu.cs5200.hotel.main.entity.Facilityconfig;

public class FacilityconfigDAO {

	private BaseDAO<Facilityconfig> baseDAO;
	
	public FacilityconfigDAO(){
		super();
		this.baseDAO = new BaseDAO<Facilityconfig>();
	}
	
	public List<Facilityconfig> getAllFacilityconfig() {
		String scope = "SELECT f FROM Facilityconfig f";
		return baseDAO.query(scope, null, null);
	}
	
	public Facilityconfig getFacilityById(Integer id) {
		return baseDAO.getById(Facilityconfig.class, id);
	}
}
