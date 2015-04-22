package edu.neu.cs5200.hotel.main.entity;

import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the ROOMTYPE database table.
 * 
 */
@Entity
@NamedQuery(name="Roomtype.findAll", query="SELECT r FROM Roomtype r")
public class Roomtype  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int capacity;

	private String description;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hId")
	private Hotel hotel;
	
	//bi-directional one-to-many association to Facility
	@OneToMany(mappedBy="roomtype", cascade = CascadeType.ALL)
	private List<Facility> facility;

	private float price;

	private String typename;
	
	private String imageURL;

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Roomtype() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public List<Facility> getFacility() {
		return facility;
	}

	public void setFacility(List<Facility> facility) {
		this.facility = facility;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

}