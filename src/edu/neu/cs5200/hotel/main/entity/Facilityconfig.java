package edu.neu.cs5200.hotel.main.entity;

import javax.persistence.*;


/**
 * The persistent class for the FACILITYCONFIG database table.
 * 
 */
@Entity
@NamedQuery(name="Facilityconfig.findAll", query="SELECT f FROM Facilityconfig f")
public class Facilityconfig  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	private String facilityName;

	public Facilityconfig() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

}