package edu.neu.cs5200.hotel.main.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import edu.neu.cs5200.hotel.main.dao.AmenityconfigDAO;
import edu.neu.cs5200.hotel.main.dao.FacilityconfigDAO;
import edu.neu.cs5200.hotel.main.dao.HotelDAO;
import edu.neu.cs5200.hotel.main.dao.HoteluserDAO;
import edu.neu.cs5200.hotel.main.dao.ServiceconfigDAO;
import edu.neu.cs5200.hotel.main.entity.Amenity;
import edu.neu.cs5200.hotel.main.entity.Amenityconfig;
import edu.neu.cs5200.hotel.main.entity.Facility;
import edu.neu.cs5200.hotel.main.entity.Hotel;
import edu.neu.cs5200.hotel.main.entity.Hoteluser;
import edu.neu.cs5200.hotel.main.entity.Roomtype;
import edu.neu.cs5200.hotel.main.entity.Service;
import edu.neu.cs5200.hotel.main.entity.Serviceconfig;
import edu.neu.cs5200.hotel.main.util.Conversion;

public class HotelManagementService {
	
	public Hotel createHotelService(HttpServletRequest request) {
		String name = request.getParameter("Name");
		String city = request.getParameter("City");
		String country = request.getParameter("Country");
		String state = request.getParameter("State");
		String address = request.getParameter("Address");
		String star = request.getParameter("Star");
		String checkIn = request.getParameter("Check-in time");
		String checkOut = request.getParameter("Check-out time");
		String description = request.getParameter("Description");
		Hotel hotel = new Hotel();
		hotel.setAddress(address);
		hotel.setCheckinTime(checkIn);
		hotel.setCheckoutTime(checkOut);
		hotel.setCity(city);
		hotel.setCountry(country);
		hotel.setDescription(description);
		hotel.setHotelName(name);
		if ((star != null) && (star != "")) {
			hotel.setStar(Integer.parseInt(star));
		}
		UserManagementService ums = new UserManagementService();
		hotel.setState(state);
		hotel.setHoteluser(ums.getHoteluserById(1));

		/////////////////////// Service
		ServiceconfigDAO serviceconfigDAO = new ServiceconfigDAO();
		List<Serviceconfig> serviceconfigs = serviceconfigDAO
				.getAllServiceconfig();
		List<Service> services = new ArrayList<Service>();
		for (Serviceconfig serviceconfig : serviceconfigs) {
			String selected = request.getParameter(serviceconfig.getId()
					.toString() + "service");
			String ifCharge = request.getParameter(serviceconfig.getId()
					.toString() + "serviceFee");
			if ("selected".equals(selected)) {
				Service service = new Service();
				service.setIfcharge(ifCharge);
				service.setHotel(hotel);
				service.setServiceconfig(serviceconfig);
				services.add(service);
			}
		}

		///////////////////////// Amenity
		AmenityconfigDAO amenityconfigDAO = new AmenityconfigDAO();
		List<Amenityconfig> amenityconfigs = amenityconfigDAO
				.getAllAmenityconfig();
		List<Amenity> amenities = new ArrayList<Amenity>();
		for (Amenityconfig amenityconfig : amenityconfigs) {
			String selected = request.getParameter(amenityconfig.getId()
					.toString() + "amenity");
			String ifCharge = request.getParameter(amenityconfig.getId()
					.toString() + "amenityFee");
			String openTime = request.getParameter(amenityconfig.getId()
					.toString() + "openTime");
			if ("selected".equals(selected)) {
				Amenity amenity = new Amenity();
				amenity.setHotel(hotel);
				amenity.setAmenityconfig(amenityconfig);
				amenity.setIfCharge(ifCharge);
				amenity.setOpenTime(openTime);
				amenities.add(amenity);
			}
		}

		////////////////// RoomType
		List<Roomtype> roomTypes = new ArrayList<Roomtype>();
		for (int i = 1; i <= 20; ++i) {
			if (request.getParameter("typeName" + i) != null
					&& request.getParameter("typeName" + i) != "") {
				Roomtype roomtype = new Roomtype();
				String typeName = request.getParameter("typeName" + i);
				String price = request.getParameter("price" + i);
				String capacity = request.getParameter("capacity" + i);
				String image = request.getParameter("image" + i);
				String typeDescription = request.getParameter("roomdescription"
						+ i);
				String[] facilitiesId = request
						.getParameterValues("facility" + i);
				List<Facility> facilities = new ArrayList<Facility>();
				FacilityconfigDAO facilityconfigDAO = new FacilityconfigDAO();
				if(facilitiesId!=null && facilitiesId.length > 0){
				for (String fId : facilitiesId) {
					Facility facility = new Facility();
					facility.setFacilityconfig(facilityconfigDAO
							.getFacilityById(Integer.parseInt(fId)));
					facilities.add(facility);
					facility.setRoomtype(roomtype);
				}
				}
				if (capacity != null && capacity != "") {
					roomtype.setCapacity(Integer.parseInt(capacity));
				}
				roomtype.setDescription(typeDescription);
				roomtype.setHotel(hotel);
				roomtype.setImageURL(image);
				if (capacity != null && capacity != "") {
					roomtype.setPrice(Float.parseFloat(price));
				}
				roomtype.setTypename(typeName);
				roomtype.setFacility(facilities);
				roomTypes.add(roomtype);
			}
		}
			hotel.setServices(services);
			hotel.setAmenities(amenities);
			hotel.setRoomtypes(roomTypes);
			return createHotel(hotel);
	}

	public Hotel createHotel(Hotel hotel) {
		HotelDAO hotelDAO = new HotelDAO();
		HoteluserDAO hoteluserDAO = new HoteluserDAO();
		Hoteluser hoteluser = hoteluserDAO.getHoteluserById(1);
		hoteluser.addHotel(hotel);
		hoteluserDAO.updateHoteluser(hoteluser);
		return hotel;
	}
	
	public List<Hotel> deleteHotel(int hotelId, int hoteluserId) {
		HotelDAO hotelDAO = new HotelDAO();
		Hotel hotel = hotelDAO.getHotelById(hotelId);
		//hotelDAO.deleteHotel(hotel);
		HoteluserDAO hoteluserDAO = new HoteluserDAO();
		Hoteluser hoteluser = hoteluserDAO.getHoteluserById(hoteluserId);
		hoteluser.removeHotel(hotel);
		hoteluserDAO.updateHoteluser(hoteluser);
		return hotelDAO.getAllHotel(hoteluserId);
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
	
	public List<Hotel> getHotelBySearch(HttpServletRequest request) {
		HotelDAO hotelDAO = new HotelDAO();
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String checkin_monthday = request.getParameter("checkin_monthday");
		String checkin_year_month = request.getParameter("checkin_year_month");
		String checkout_monthday = request.getParameter("checkout_monthday");
		String checkout_year_month = request.getParameter("checkout_year_month");
		String idf = request.getParameter("idf");
		Date checkinDate = new Date();
		Date checkoutDate = new Date();
		if (checkin_monthday != null && checkin_year_month != null 
				&& checkout_monthday != null && checkout_year_month != null) {
		if (!"0".equals(checkin_monthday) && !"0".equals(checkin_year_month) 
				&& !"0".equals(checkout_monthday) && !"0".equals(checkout_year_month)) {
			checkinDate = Conversion.string2Date(checkin_year_month + "-" + checkin_monthday);
			checkoutDate = Conversion.string2Date(checkout_year_month + "-" + checkout_monthday);
		}
		}
		if((idf != null && "on".equals(idf)) || "0".equals(checkin_monthday) ||
				"0".equals(checkin_year_month) || "0".equals(checkout_monthday)
				|| "0".equals(checkout_year_month)) {
			return hotelDAO.getHotelBySearch(city, country);
		}else {
			return hotelDAO.getHotelBySearchByDate(city, country, checkinDate, checkoutDate);
		}
	}
	
}
