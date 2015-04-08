package edu.neu.cs5200.hotel.main.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ROOMTYPE database table.
 * 
 */
@Entity
@NamedQuery(name="Roomtype.findAll", query="SELECT r FROM Roomtype r")
public class Roomtype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int capacity;

	private String description;

	private float price;

	private String typeName;

	//bi-directional many-to-one association to Facility
	@OneToMany(mappedBy="roomtype")
	private List<Facility> facilities;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="roomtype")
	private List<Reservation> reservations;

	//bi-directional many-to-one association to Hotel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hId")
	private Hotel hotel;

	//bi-directional many-to-one association to Occupier
	@OneToMany(mappedBy="roomtype")
	private List<Occupier> occupiers;

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

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<Facility> getFacilities() {
		return this.facilities;
	}

	public void setFacilities(List<Facility> facilities) {
		this.facilities = facilities;
	}

	public Facility addFacility(Facility facility) {
		getFacilities().add(facility);
		facility.setRoomtype(this);

		return facility;
	}

	public Facility removeFacility(Facility facility) {
		getFacilities().remove(facility);
		facility.setRoomtype(null);

		return facility;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setRoomtype(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setRoomtype(null);

		return reservation;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Occupier> getOccupiers() {
		return this.occupiers;
	}

	public void setOccupiers(List<Occupier> occupiers) {
		this.occupiers = occupiers;
	}

	public Occupier addOccupier(Occupier occupier) {
		getOccupiers().add(occupier);
		occupier.setRoomtype(this);

		return occupier;
	}

	public Occupier removeOccupier(Occupier occupier) {
		getOccupiers().remove(occupier);
		occupier.setRoomtype(null);

		return occupier;
	}

}