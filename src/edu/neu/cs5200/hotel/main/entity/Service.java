package edu.neu.cs5200.hotel.main.entity;

import javax.persistence.*;


/**
 * The persistent class for the SERVICE database table.
 * 
 */
@Entity
@NamedQuery(name="Service.findAll", query="SELECT s FROM Service s")
public class Service  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hId")
	private Hotel hotel;

	private String ifcharge;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="scId")
	private Serviceconfig serviceconfig;

	public Service() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIfcharge() {
		return this.ifcharge;
	}

	public void setIfcharge(String ifcharge) {
		this.ifcharge = ifcharge;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Serviceconfig getServiceconfig() {
		return serviceconfig;
	}

	public void setServiceconfig(Serviceconfig serviceconfig) {
		this.serviceconfig = serviceconfig;
	}

}