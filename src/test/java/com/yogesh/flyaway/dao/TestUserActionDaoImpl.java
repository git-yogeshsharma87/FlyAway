package com.yogesh.flyaway.dao;

import static org.junit.Assert.fail;

import org.hibernate.HibernateException;
import org.junit.Test;

import com.yogesh.flyaway.model.UserDetails;

public class TestUserActionDaoImpl {

	
	  @Test public void testAddUser() { UserDetails user = new
	  UserDetails("abc@abc.com", "hhyygg123", "abc", "1234644", true);
	  UserActionDao ua = new UserActionDaoImpl() ; try { ua.addUser(user);
	  
	  } catch (HibernateException e) { fail("Not added"); }
	  
	  
	  }
	 
		
		/*
		 * @Test public void testUserLogin() { // UserDetails user = new UserDetails();
		 * UserActionDao ua = new UserActionDaoImpl(); try { ua.userLogin("abc",
		 * "hhyygg123");
		 * 
		 * } catch (HibernateException e) { fail("Not added"); }
		 * 
		 * }
		 */

}
