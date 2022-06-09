package com.ers.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.User;
import com.ers.services.UserService;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static UserService userService = new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if("update".equalsIgnoreCase(action)) {
			
			updateUser(request, response);
			response.sendRedirect("user-profile.jsp?action=view_info");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static void updateUser(HttpServletRequest request, HttpServletResponse response) {
		String username = (String) request.getParameter("uname");
		String password = (String) request.getParameter("psw");
		
		User user = (User) request.getSession().getAttribute("user");
		user.setUserName(username);
		user.setPassword(password);
		
		userService.updateUser(user);
		
	}
}
