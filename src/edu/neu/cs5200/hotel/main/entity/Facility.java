package edu.neu.cs5200.hotel.main.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FACILITY database table.
 * 
 */
@Entity
@NamedQuery(name="Facility.findAll", query="SELECT f FROM Facility f")
public class Facility implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int amount;

	private String description;

	private String facilityName;

	private byte ifCharge;

	//bi-directional many-to-one association to Roomtype
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rtId")
	private Roomtype roomtype;

	public Facility() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFacilityName() {
		return this.facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public byte getIfCharge() {
		return this.ifCharge;
	}

	public void setIfCharge(byte ifCharge) {
		this.ifCharge = ifCharge;
	}

	public Roomtype getRoomtype() {
		return this.roomtype;
	}

	public void setRoomtype(Roomtype roomtype) {
		this.roomtype = roomtype;
	}

}