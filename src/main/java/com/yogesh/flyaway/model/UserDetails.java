package com.yogesh.flyaway.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uId;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "name",unique = true)
	private String name;
	
	@Column(name = "aadhaar")
	private String aadhaar;
	
	@Column(name = "role")
	private boolean role;
	
	@OneToMany(mappedBy = "users")
	private List<FlightDetails> flights;
	


	public UserDetails() {
		super();
	}

	public UserDetails(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public long getuId() {
		return uId;
	}

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	
	public List<FlightDetails> getFlights() {
		return flights;
	}

	public void setFlights(List<FlightDetails> flights) {
		this.flights = flights;
	}

	public UserDetails(String email, String password, String name, String aadhaar, boolean role,
			List<FlightDetails> flights) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.aadhaar = aadhaar;
		this.role = role;
		this.flights = flights;
	}

	public UserDetails(String email, String password, String name, String aadhaar, boolean role) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.aadhaar = aadhaar;
		this.role = role;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(String aadhaar) {
		this.aadhaar = aadhaar;
	}

	@Override
	public int hashCode() {
		return Objects.hash(uId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetails other = (UserDetails) obj;
		return uId == other.uId;
	}
	
	
	
}
