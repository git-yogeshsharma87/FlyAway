package com.yogesh.flyaway.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.catalina.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yogesh.flyaway.model.FlightDetails;
import com.yogesh.flyaway.model.UserDetails;
import com.yogesh.flyaway.util.FlyAwayUtil;

public class UserActionDaoImpl implements UserActionDao {

	@Override
	public List<FlightDetails> searchFlights(String fSrc, String fDest, Date fDate) {
		
		Transaction transaction = null;
		List<FlightDetails> flightsList = null;
		
		try(Session session = FlyAwayUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			flightsList = session.createQuery("from flight_details where source=fSrc and destination = fDest and date= fDate").list();
			
			transaction.commit();
								
		}
		
		return null;
	}

	@Override
	public void addUser(UserDetails user) throws HibernateException {
		Transaction transaction = null;
		
		try (Session session = FlyAwayUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			session.save(user);
			
			transaction.commit();
					
		}
		catch (HibernateException e) {
		 if(transaction != null) {
			 transaction.rollback();
		 }
			e.printStackTrace();
			throw e;			
		}
	}

	@Override
	public void addFlight(FlightDetails flightDetails) throws HibernateException {
		Transaction transaction = null;
		
		try (Session session = FlyAwayUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			session.save(flightDetails);
			
			transaction.commit();
					
		}
		catch (HibernateException e) {
		 if(transaction != null) {
			 transaction.rollback();
		 }
			e.printStackTrace();
			throw e;			
		}		
	}

	@Override
	public void userLogin(String username, String password) throws HibernateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adminLogin(String username, String password) throws HibernateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePass(String username, String password) throws HibernateException {
		// TODO Auto-generated method stub
		
	}



	

	
	
	
	
	

}
