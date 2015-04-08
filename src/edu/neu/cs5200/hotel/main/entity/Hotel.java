package edu.neu.cs5200.hotel.main.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HOTEL database table.
 * 
 */
@Entity
@NamedQuery(name="Hotel.findAll", query="SELECT h FROM Hotel h")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	private String checkinTime;

	private String checkoutTime;

	private String city;

	private String country;

	private String description;

	private String hotelName;

	private int rating;

	private int star;

	private String state;

	//bi-directional many-to-one association to Amenity
	@OneToMany(mappedBy="hotel")
	private List<Amenity> amenities;

	//bi-directional many-to-one association to Hoteluser
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="huId")
	private Hoteluser hoteluser;

	//bi-directional many-to-one association to Roomtype
	@OneToMany(mappedBy="hotel")
	private List<Roomtype> roomtypes;

	//bi-directional many-to-one association to Service
	@OneToMany(mappedBy="hotel")
	private List<Service> services;

	//bi-directional many-to-one association to Surrounding
	@OneToMany(mappedBy="hotel")
	private List<Surrounding> surroundings;

	public Hotel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCheckinTime() {
		return this.checkinTime;
	}

	public void setCheckinTime(String checkinTime) {
		this.checkinTime = checkinTime;
	}

	public String getCheckoutTime() {
		return this.checkoutTime;
	}

	public void setCheckoutTime(String checkoutTime) {
		this.checkoutTime = checkoutTime;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHotelName() {
		return this.hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getStar() {
		return this.star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Amenity> getAmenities() {
		return this.amenities;
	}

	public void setAmenities(List<Amenity> amenities) {
		this.amenities = amenities;
	}

	public Amenity addAmenity(Amenity amenity) {
		getAmenities().add(amenity);
		amenity.setHotel(this);

		return amenity;
	}

	public Amenity removeAmenity(Amenity amenity) {
		getAmenities().remove(amenity);
		amenity.setHotel(null);

		return amenity;
	}

	public Hoteluser getHoteluser() {
		return this.hoteluser;
	}

	public void setHoteluser(Hoteluser hoteluser) {
		this.hoteluser = hoteluser;
	}

	public List<Roomtype> getRoomtypes() {
		return this.roomtypes;
	}

	public void setRoomtypes(List<Roomtype> roomtypes) {
		this.roomtypes = roomtypes;
	}

	public Roomtype addRoomtype(Roomtype roomtype) {
		getRoomtypes().add(roomtype);
		roomtype.setHotel(this);

		return roomtype;
	}

	public Roomtype removeRoomtype(Roomtype roomtype) {
		getRoomtypes().remove(roomtype);
		roomtype.setHotel(null);

		return roomtype;
	}

	public List<Service> getServices() {
		return this.services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public Service addService(Service service) {
		getServices().add(service);
		service.setHotel(this);

		return service;
	}

	public Service removeService(Service service) {
		getServices().remove(service);
		service.setHotel(null);

		return service;
	}

	public List<Surrounding> getSurroundings() {
		return this.surroundings;
	}

	public void setSurroundings(List<Surrounding> surroundings) {
		this.surroundings = surroundings;
	}

	public Surrounding addSurrounding(Surrounding surrounding) {
		getSurroundings().add(surrounding);
		surrounding.setHotel(this);

		return surrounding;
	}

	public Surrounding removeSurrounding(Surrounding surrounding) {
		getSurroundings().remove(surrounding);
		surrounding.setHotel(null);

		return surrounding;
	}

}