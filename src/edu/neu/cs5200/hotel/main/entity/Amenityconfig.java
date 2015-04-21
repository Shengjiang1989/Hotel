package edu.neu.cs5200.hotel.main.entity;

import javax.persistence.*;


/**
 * The persistent class for the AMENITYCONFIG database table.
 * 
 */
@Entity
@NamedQuery(name="Amenityconfig.findAll", query="SELECT a FROM Amenityconfig a")
public class Amenityconfig  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String amenityName;

	private String description;

	public Amenityconfig() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

}