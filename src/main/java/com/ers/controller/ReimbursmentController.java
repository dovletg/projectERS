package com.ers.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.Reimbursment;
import com.ers.model.User;
import com.ers.services.ReimbursmentService;

/**
 * Servlet implementation class ReimbursmentController
 */
@WebServlet("/ReimbursmentController")
public class ReimbursmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static ReimbursmentService rbService = new ReimbursmentService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbursmentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if("add_request".equalsIgnoreCase(action)) {
			// add request
			addRequest(request, response);
			response.sendRedirect("view_requests.jsp?action=pending");
		}else if ("view_pending_requests".equalsIgnoreCase(action)) {
			
		}else if ("view_resolved_requests".equalsIgnoreCase(action)) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static void addRequest(HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		String title = request.getParameter("title");
		String desc = request.getParameter("description");
		Timestamp created = new Timestamp(new Date().getTime());
		
		Reimbursment rb = new Reimbursment();
		rb.setTitle(title);
		rb.setDescription(desc);
		rb.setStatus("pending");
		rb.setSubmitted(created);
		rb.setResolved(created);
		rb.setResolvedBy("None");
		rb.setUser(user);
		
		rbService.addReimbursment(rb);
		
	}

}
