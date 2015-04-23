package edu.neu.cs5200.hotel.main.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.neu.cs5200.hotel.main.basedao.BaseDAO;
import edu.neu.cs5200.hotel.main.entity.Hotel;
import edu.neu.cs5200.hotel.main.entity.Hoteluser;

public class HotelDAO {


	private BaseDAO<Hotel> baseDAO;
	
	public HotelDAO(){
		super();
		this.baseDAO = new BaseDAO<Hotel>();
	}

	public Hotel createHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return this.baseDAO.create(hotel);
	}

	public List<Hotel> getAllHotel(int hotelUserId) {
		// TODO Auto-generated method stub
		HoteluserDAO hoteluserDAO = new HoteluserDAO();
		//ArrayList<Integer> paras = new ArrayList<Integer>();
		//paras.add(hotelUserId);
		//ArrayList<String> paramName = new ArrayList<String>();
		//paramName.add("huId");
		//baseDAO.query("SELECT * FROM HOTEL WHERE huId =?huId", paramName, paras);
		Hoteluser hoteluser = hoteluserDAO.getHoteluserById(hotelUserId);
		return hoteluser.getHotels();
	}

	public void deleteHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		Hotel mHotel = this.baseDAO.getById(Hotel.class, hotel.getId());
		baseDAO.delete(mHotel);
	}

	public void updateHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		baseDAO.update(hotel);
	}
	
	public Hotel getHotelById(int id) {
		return baseDAO.getById(Hotel.class, id);
	}
	
	public List<Hotel> getHotelByName(String hotelName, int hotelUserId) {
		String scope = "select h from Hotel h where h.huId = :huId AND h.hotelname = :hotelname";
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(hotelUserId);
		paras.add(hotelName);
		ArrayList<String> paramName = new ArrayList<String>();
		paramName.add("huId");
		paramName.add("hotelname");
		return this.baseDAO.query(scope, paramName, paras);
	}

	public List<Hotel> getHotelBySearch(String city, String country) {
		// TODO Auto-generated method stub
		String scope = "select h from Hotel h where h.city = :city AND h.country = :country";
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(city);
		paras.add(country);
		ArrayList<String> paramName = new ArrayList<String>();
		paramName.add("city");
		paramName.add("country");
		return this.baseDAO.query(scope, paramName, paras);
	}

	public List<Hotel> getHotelBySearchByDate(String city, String country,
			Date checkinDate, Date checkoutDate) {
		// TODO Auto-generated method stub
		return null;
	}
}
