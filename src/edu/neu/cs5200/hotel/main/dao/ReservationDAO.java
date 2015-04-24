package edu.neu.cs5200.hotel.main.dao;

import edu.neu.cs5200.hotel.main.basedao.BaseDAO;
import edu.neu.cs5200.hotel.main.entity.Reservation;

public class ReservationDAO {

	private BaseDAO<Reservation> baseDAO;
	
	public ReservationDAO(){
		super();
		this.baseDAO = new BaseDAO<Reservation>();
	}
	
	public Reservation createReservation(Reservation r) {
		return this.baseDAO.create(r);
	}
}
