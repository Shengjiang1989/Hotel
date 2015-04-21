package edu.neu.cs5200.hotel.main.entity;

import javax.persistence.*;


/**
 * The persistent class for the SERVICECONFIG database table.
 * 
 */
@Entity
@NamedQuery(name="Serviceconfig.findAll", query="SELECT s FROM Serviceconfig s")
public class Serviceconfig  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String description;

	private String serviceName;

	public Serviceconfig() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

}