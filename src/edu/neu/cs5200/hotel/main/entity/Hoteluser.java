package edu.neu.cs5200.hotel.main.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the HOTELUSER database table.
 * 
 */
@Entity
@NamedQuery(name="Hoteluser.findAll", query="SELECT h FROM Hoteluser h")
public class Hoteluser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String password;

	@Temporal(TemporalType.DATE)
	private Date regDate;

	private String ssn;

	private String username;

	//bi-directional many-to-one association to Hotel
	@OneToMany(mappedBy="hoteluser", cascade = CascadeType.ALL)
	private List<Hotel> hotels;

	public Hoteluser() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegDate() {
		return this.regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Hotel> getHotels() {
		return this.hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public Hotel addHotel(Hotel hotel) {
		getHotels().add(hotel);
		hotel.setHoteluser(this);

		return hotel;
	}

	public Hotel removeHotel(Hotel hotel) {
		getHotels().remove(hotel);
		hotel.setHoteluser(null);

		return hotel;
	}

}