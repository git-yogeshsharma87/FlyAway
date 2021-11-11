package com.yogesh.flyaway.util;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.yogesh.flyaway.model.FlightDetails;
import com.yogesh.flyaway.model.UserDetails;

/*Utility class to initialize hibernate session*/


public class FlyAwayUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory == null) {
			try {
				
				Configuration config = new Configuration();
				Properties props = new Properties();
				props.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				props.put(Environment.URL, "jdbc:mysql://localhost:3306/flyawayDB?useSSL=false");
				props.put(Environment.USER, "root");
				props.put(Environment.PASS, "Jsr@30071987"); 
				props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
				props.put(Environment.SHOW_SQL, "true");
				props.put(Environment.FORMAT_SQL,"true");
				
				props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				
				props.put(Environment.HBM2DDL_AUTO, "update");
				
				config.setProperties(props);
				
				
				config.addAnnotatedClass(FlightDetails.class);
				config.addAnnotatedClass(UserDetails.class);
				
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
				
				System.out.println("Service registry is created");
				
				sessionFactory = config.buildSessionFactory(serviceRegistry);
				
					
			}
			catch (HibernateException e) {
				e.printStackTrace();
			}
			
			
		}
		
			
		return sessionFactory;
	}
	
	public static void main(String[] args) {
		Session session = getSessionFactory().openSession();
	}
}
