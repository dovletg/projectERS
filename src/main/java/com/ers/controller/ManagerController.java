package com.ers.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.User;
import com.ers.services.ManagerService;

/**
 * Servlet implementation class ManagerController
 */
@WebServlet("/ManagerController")
public class ManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       static ManagerService managerService = new ManagerService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		approveRequest(request, response, action);
		response.sendRedirect("approve_request.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static void approveRequest(HttpServletRequest request, HttpServletResponse response, String approve) {
		int reqId = Integer.parseInt(request.getParameter("reqId"));
		int authId = Integer.parseInt(request.getParameter("userId"));
		
		User currentUser = (User) request.getSession().getAttribute("user");
		String resolvedBy = currentUser.getUserName();
		
		if("approve".equalsIgnoreCase(approve)) {
			managerService.approveRequest(reqId, authId, resolvedBy);
		}else if ("deny".equalsIgnoreCase(approve)) {
			managerService.denyRequest(reqId, authId, resolvedBy);
		}
		
	}

}
