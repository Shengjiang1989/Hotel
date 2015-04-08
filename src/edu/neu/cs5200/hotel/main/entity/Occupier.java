package edu.neu.cs5200.hotel.main.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the occupier database table.
 * 
 */
@Entity
@NamedQuery(name="Occupier.findAll", query="SELECT o FROM Occupier o")
public class Occupier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date occupiedDate;

	//bi-directional many-to-one association to Roomtype
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rtId")
	private Roomtype roomtype;

	public Occupier() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOccupiedDate() {
		return this.occupiedDate;
	}

	public void setOccupiedDate(Date occupiedDate) {
		this.occupiedDate = occupiedDate;
	}

	public Roomtype getRoomtype() {
		return this.roomtype;
	}

	public void setRoomtype(Roomtype roomtype) {
		this.roomtype = roomtype;
	}

}