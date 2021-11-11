package com.yogesh.flyaway.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.catalina.User;
import org.hibernate.HibernateException;

import com.yogesh.flyaway.model.FlightDetails;
import com.yogesh.flyaway.model.UserDetails;

public interface UserActionDao {
	
	List<FlightDetails> searchFlights(String fSrc, String fDest, Date fDate );
	
	void addUser(UserDetails user) throws HibernateException;
	
	void addFlight(FlightDetails flightDetails) throws HibernateException;
	
	boolean userLogin(String username, String password) throws HibernateException;
	
	boolean adminLogin(String username, String password) throws HibernateException;
	
	boolean bookFlight(String username, FlightDetails flight);

	UserDetails userDetails(String username);
	
	boolean changePass(String username, String password) throws HibernateException;
	
	

}
