package edu.neu.cs5200.hotel.main.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ADMIN database table.
 * 
 */
@Entity
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String password;

	private String sponsorAccount;

	private String username;

	public Admin() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSponsorAccount() {
		return this.sponsorAccount;
	}

	public void setSponsorAccount(String sponsorAccount) {
		this.sponsorAccount = sponsorAccount;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}