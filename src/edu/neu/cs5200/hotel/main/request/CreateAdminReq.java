package edu.neu.cs5200.hotel.main.request;

public class CreateAdminReq {
	private String password;

	private String sponsoraccount;

	private String username;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSponsoraccount() {
		return sponsoraccount;
	}

	public void setSponsoraccount(String sponsoraccount) {
		this.sponsoraccount = sponsoraccount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
