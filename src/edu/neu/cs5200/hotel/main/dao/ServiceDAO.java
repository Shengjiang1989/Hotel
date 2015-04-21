package edu.neu.cs5200.hotel.main.dao;

import edu.neu.cs5200.hotel.main.basedao.BaseDAO;
import edu.neu.cs5200.hotel.main.entity.Service;

public class ServiceDAO {
	private BaseDAO<Service> baseDAO;
	
	public ServiceDAO(){
		super();
		this.baseDAO = new BaseDAO<Service>();
	}
	public Service createService(Service service) {
		return baseDAO.create(service);
	}
}
