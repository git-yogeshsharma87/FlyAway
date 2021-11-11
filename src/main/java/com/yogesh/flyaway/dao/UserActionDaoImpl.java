package com.yogesh.flyaway.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yogesh.flyaway.model.FlightDetails;
import com.yogesh.flyaway.model.UserDetails;
import com.yogesh.flyaway.util.FlyAwayUtil;

public class UserActionDaoImpl implements UserActionDao {

	@Override
	public List<FlightDetails> searchFlights(String fSrc, String fDest, Date fDate) {

		// Transaction transaction = null;
		List<FlightDetails> flightsList = null;

		try (Session session = FlyAwayUtil.getSessionFactory().openSession()) {

			 flightsList = (List<FlightDetails>) session.createQuery("from flight_details where source = :src and destination = :dest and date = :date").setParameter("src", fSrc).setParameter("dest", fDest).setParameter("date", fDate).getResultList();
			 
			// transaction = session.beginTransaction();
			// flightsList = session.createQuery("from flight_details where source="+fSrc
			// "and destination ="+ fDest "and date= fDate").list();
//			String hql = "from flight_details where source = :src and destination = :dest and date = :date";
//			Query query = session.createQuery(hql);
//			query.setParameter("src", fSrc);
//			query.setParameter("dest", fDest);
//			query.setParameter("date", fDate);
//			flightsList = query.list();
			// transaction.commit();

		} catch (HibernateException e) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
			e.printStackTrace();
			throw e;
		}

		return flightsList;
	}

	@Override
	public void addUser(UserDetails user) throws HibernateException {
		Transaction transaction = null;

		try (Session session = FlyAwayUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.save(user);

			transaction.commit();

		} catch (HibernateException e) {
			if (transaction != null) {
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

		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean userLogin(String username, String password) throws HibernateException {
		Transaction transaction = null;
		UserDetails result = null;
		try (Session session = FlyAwayUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			result = (UserDetails) session
					.createQuery("from user_details U where U.name = :userName").setParameter("username", username)
					.uniqueResult();
			if (result != null && result.getPassword().equals(password)) {
				return true;
			}
			transaction.commit();
		} catch (HibernateException e) {
			if(transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
			throw e;
		}
		return false;
	}

	@Override
	public boolean adminLogin(String username, String password) throws HibernateException {
		boolean status = false;
		UserDetails result = null;
		try (Session session = FlyAwayUtil.getSessionFactory().openSession()) {
			result = (UserDetails) session.createQuery(
					"SELECT u.role from user_details where name = " + username + " and password = " + password + " ");
			if (result.isRole()) {
				status = true;
			}

		} catch (HibernateException e) {

			e.printStackTrace();
			throw e;
		}
		return status;
	}

	@Override
	public boolean changePass(String username, String password) throws HibernateException {
		if(!adminLogin(username,password)) {
			return false;
		}
		boolean status = false;
		Transaction transaction = null;
		try (Session session = FlyAwayUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			String hql = "UPDATE user_details set name = :uname and password = :pass ";
			Query query = session.createQuery(hql);
			query.setParameter("uname", username);
			query.setParameter("pass", password);
			int result = query.executeUpdate();
			transaction.commit();
			if(result!=0) {
				status = true;

			}
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			throw e;
		}
		return status;

	}

	@Override
	public boolean bookFlight(String username, FlightDetails flight) {
		boolean status = false;
		Transaction transaction = null;
		UserDetails user = null;
		try (Session session = FlyAwayUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			user = (UserDetails) session.createQuery("from user_details where name ="+username);
					
			flight.setUsers(user);
			transaction.commit();
				status = true;

		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			throw e;
		}
		return status;
	}

	@Override
	public UserDetails userDetails(String username) {
		UserDetails userDetail = null;

		try (Session session = FlyAwayUtil.getSessionFactory().openSession()) {

			userDetail = (UserDetails) session.createQuery("from user_details where name = "+username);
	
		
		} catch (HibernateException e) {
//			if (transaction != null) {
//			transaction.rollback();
//		}
		e.printStackTrace();
		throw e;
	}

	return userDetail;

}
}
