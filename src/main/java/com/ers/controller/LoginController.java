package com.ers.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.model.User;
import com.ers.services.UserService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static UserService userService = new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname");
		String pass = request.getParameter("psw");
		String action = request.getParameter("action");
		
		if("login".equalsIgnoreCase(action)) {

			try {
				
				login(request, response, username, pass);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if("logout".equalsIgnoreCase(action)) {
			request.getSession().removeAttribute("user");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static void login(HttpServletRequest request, HttpServletResponse response,String username, String password) throws Exception {
		User user = userService.getUserByUserNameAndPassword(username, password);
		
		if(user != null) {
			// login successfull
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			if("normal".equalsIgnoreCase(user.getType()))
				response.sendRedirect("user-home.jsp");
			else if("manager".equalsIgnoreCase(user.getType()))
				response.sendRedirect("manager-home.jsp");
		}else {
			response.getWriter().print("Invalid entry...");
		}
	}
}
