package edu.neu.cs5200.hotel.main.request;

import java.util.Date;
import java.util.List;


import edu.neu.cs5200.hotel.main.entity.Hotel;

public class CreateHotelUserReq {
	private String password;

	private Date regDate;

	private String ssn;

	private String username;

	//bi-directional many-to-one association to Hotel
	private List<Hotel> hotels;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

}
