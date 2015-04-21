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

	//bi-directional many-to-one association to Roomtype
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rtId")
	private Roomtype roomtype;
	
	//bi-directional many-to-one association to Roomtype
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fcId")
	private Facilityconfig facilityconfig;

	public Facility() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Roomtype getRoomtype() {
		return this.roomtype;
	}

	public void setRoomtype(Roomtype roomtype) {
		this.roomtype = roomtype;
	}

	public Facilityconfig getFacilityconfig() {
		return facilityconfig;
	}

	public void setFacilityconfig(Facilityconfig facilityconfig) {
		this.facilityconfig = facilityconfig;
	}

}