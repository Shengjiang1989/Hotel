package edu.neu.cs5200.hotel.main.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AMENITY database table.
 * 
 */
@Entity
@NamedQuery(name="Amenity.findAll", query="SELECT a FROM Amenity a")
public class Amenity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String amenityName;

	private String description;

	private byte ifCharge;

	private String openTime;

	//bi-directional many-to-one association to Hotel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hId")
	private Hotel hotel;

	public Amenity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAmenityName() {
		return this.amenityName;
	}

	public void setAmenityName(String amenityName) {
		this.amenityName = amenityName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getIfCharge() {
		return this.ifCharge;
	}

	public void setIfCharge(byte ifCharge) {
		this.ifCharge = ifCharge;
	}

	public String getOpenTime() {
		return this.openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}