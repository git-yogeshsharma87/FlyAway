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
		case "/searchFlight":
			
			break;
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

		case "/adminHome":
			
			break;

			
		case "/ForgotPassword":
			
			break;

		case "/HomePage.jsp":

			break;

		case "/adminLogin":

			break;

		case "/UserRegistration":

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
	

}
