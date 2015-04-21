package edu.neu.cs5200.hotel.main.dao;

import java.util.List;

import edu.neu.cs5200.hotel.main.basedao.BaseDAO;
import edu.neu.cs5200.hotel.main.entity.Serviceconfig;

public class ServiceconfigDAO {
	private BaseDAO<Serviceconfig> baseDAO;
	
	public ServiceconfigDAO(){
		super();
		this.baseDAO = new BaseDAO<Serviceconfig>();
	}

	public Serviceconfig createServiceconfig(Serviceconfig serviceconfig) {
		// TODO Auto-generated method stub
		return this.baseDAO.create(serviceconfig);
	}

	public List<Serviceconfig> getAllServiceconfig() {
		// TODO Auto-generated method stub
		String scope = "SELECT s FROM Serviceconfig s";
		return baseDAO.query(scope, null, null);
	}
	
}
