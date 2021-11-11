package com.yogesh.flyaway.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yogesh.flyaway.dao.UserActionDao;
import com.yogesh.flyaway.dao.UserActionDaoImpl;
import com.yogesh.flyaway.model.UserDetails;

/**
 * Controller to call model and views
 * @author YOGESH
 */
@WebServlet("/")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserActionDao userAction ;
    public UserController() {
        super();
    }
    
    public void init() {
        userAction = new UserActionDaoImpl();   

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
		// to search flight
		case "/searchFlight":
			response.sendRedirect("HomePage");
			
			break;
			// user login
		case "/login":
			response.sendRedirect("login.jsp");
			try {
				authenticate(request,response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

			// To add a flight
		case "/adminHome":
			
			break;

			// admin pass change/reset
		case "/ForgotPassword":
			
			break;

			// admin login
		case "/adminLogin":
				System.out.println();
			break;
			
			// User registration
		case "/UserRegistration":
			registerUser(request,response);
			break;

		default:
			System.out.println("The path is"+ request.getServletPath());
			response.getWriter().write("Inside"+request.getServletPath());
			break;
		}	
		}

	private void authenticate(HttpServletRequest request,HttpServletResponse response) throws ServletException, Exception {
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		if(userAction.userLogin(username, password)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login-success");
			dispatcher.forward(request, response);
		}
		else {
			throw new Exception("Login Not Successful");
		}
		
	}
	
	private void registerUser(HttpServletRequest request, HttpServletResponse response) {
		
		UserDetails userInput = new UserDetails(request.getParameter("email"), 
				request.getParameter("password"), request.getParameter("name"), 
				request.getParameter("aadhaar"), false);
		
		
		UserActionDao dao = new UserActionDaoImpl();
		
		dao.addUser(userInput);
		
	}

}
