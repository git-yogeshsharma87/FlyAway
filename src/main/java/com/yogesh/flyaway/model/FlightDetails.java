package com.yogesh.flyaway.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight_details")
public class FlightDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long fId ;
	
	@Column(name = "flight_name")
	private String fName;
	
	@Column(name = "source")
	private String fSrc;
	
	@Column(name = "destination")
	private String fDest;
	
	@Column(name = "price")
	private int fPrice;
	
	@Column(name = "date")
	private Date fDate;
	
	// Parameterized Constructor to pull all flight details 
	public FlightDetails(String flightName, String fSrc, String fDest, int fPrice, Date fDate) {
		super();
		this.fName = flightName;
		this.fSrc = fSrc;
		this.fDest = fDest;
		this.fPrice = fPrice;
		this.fDate = fDate;
	}
	
	
   // To search a flight
	public FlightDetails(String fSrc, String fDest, Date fDate) {
		super();
		this.fSrc = fSrc;
		this.fDest = fDest;
		this.fDate = fDate;
	}



	// GETTERS AND SETTERS
	public String getFlightName() {
		return fName;
	}

	public void setFlightName(String fName) {
		this.fName = fName;
	}

	public String getfSrc() {
		return fSrc;
	}

	public void setfSrc(String fSrc) {
		this.fSrc = fSrc;
	}

	public String getfDest() {
		return fDest;
	}

	public void setfDest(String fDest) {
		this.fDest = fDest;
	}

	public int getfPrice() {
		return fPrice;
	}

	public void setfPrice(int fPrice) {
		this.fPrice = fPrice;
	}

	public Date getfDate() {
		return fDate;
	}

	public void setfDate(Date fDate) {
		this.fDate = fDate;
	}

	@Override
	public String toString() {
		return "FlightDetails [flightId=" + fId + ", flightName=" + fName + ", fSrc=" + fSrc + ", fDest="
				+ fDest + ", fPrice=" + fPrice + ", fDate=" + fDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightDetails other = (FlightDetails) obj;
		return fId == other.fId;
	}



	
}
