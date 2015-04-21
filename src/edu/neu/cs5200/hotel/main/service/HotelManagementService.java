package edu.neu.cs5200.hotel.main.service;

import java.util.List;

import edu.neu.cs5200.hotel.main.dao.HotelDAO;
import edu.neu.cs5200.hotel.main.entity.Hotel;

public class HotelManagementService {

	public Hotel createHotel(Hotel hotel) {
		HotelDAO hotelDAO = new HotelDAO();
		return hotelDAO.createHotel(hotel);
	}
	
	public List<Hotel> deleteHotel(Hotel hotel) {
		HotelDAO hotelDAO = new HotelDAO();
		hotelDAO.deleteHotel(hotel);
		return hotelDAO.getAllHotel(hotel.getHoteluser().getId());
	}
	
	public List<Hotel> updateHotel(Hotel hotel) {
		HotelDAO hotelDAO = new HotelDAO();
		hotelDAO.updateHotel(hotel);
		return hotelDAO.getAllHotel(hotel.getHoteluser().getId());
	}
	
	public Hotel getHotelById(int id) {
		HotelDAO hotelDAO = new HotelDAO();
		return hotelDAO.getHotelById(id);
	}
	
	public List<Hotel> getAllHotels(int hotelUserId) {
		HotelDAO hotelDAO = new HotelDAO();
		return hotelDAO.getAllHotel(hotelUserId);
	}
	
	public List<Hotel> getHotelByName(String hotelName, int hotelUserId) {
		HotelDAO hotelDAO = new HotelDAO();
		return hotelDAO.getHotelByName(hotelName, hotelUserId);
	}
}
