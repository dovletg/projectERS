
<%@page import="com.ers.model.Reimbursment"%>
<%@page import="com.ers.model.User"%>
<%@page import="com.ers.services.ReimbursmentService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Requests</title>

<style>
a:link, a:visited {
  background-color: #1a2335;
  color: white;
  padding: 15px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: #1a2335;
}
</style>
</head>
<body>
<center>
<h1>Expense Reimbursement System</h1>
<br/>
<%
	String action = request.getParameter("action");
ReimbursmentService rb = new ReimbursmentService();

if("pending".equalsIgnoreCase(action)){

	User user = (User) request.getSession().getAttribute("user");
	int userId = user.getId();
		
	
%>
<h2>Employee Pending Requests</h2>
<br>

<table border="1px">
  <tr>
    <th>Reimbursment ID</th>
    <th>Title</th>
    <th>Description</th>
    <th>Submitted At</th>
    <th>Status</th>
  </tr>
  <% // fill pending requests table
  for(Reimbursment r: rb.getAllPendingReimbursmentByAuthor(userId)){
  %>
  <tr>
    <td><%=r.getId() %></td>
    <td><%=r.getTitle() %></td>
    <td><%=r.getDescription() %></td>
    <td><%=r.getSubmitted().toString() %></td>
    <td><%=r.getStatus() %></td>
  </tr>
  <%} // end loop %>
</table>

<%}// end of pending 
else if("resolved".equalsIgnoreCase(action)){
	User user = (User) request.getSession().getAttribute("user");
	int userId = user.getId();
%>

<h2>Employee Resolved Requests</h2>
<br>

<table border="1px">
  <tr>
    <th>Reimbursment ID</th>
    <th>Title</th>
    <th>Description</th>
    <th>Resolved By</th>
    <th>Submitted At</th>
    <th>Resolved At</th>
    <th>Status</th>
  </tr>
  <% // fill pending requests table
  for(Reimbursment r: rb.getAllResolvedReimbursmentByAuthor(userId)){
  %>
  <tr>
    <td><%=r.getId() %></td>
    <td><%=r.getTitle() %></td>
    <td><%=r.getDescription() %></td>
    <td><%=r.getResolvedBy()%></td>
    <td><%=r.getSubmitted().toString() %></td>
    <td><%=r.getResolved().toString() %></td>
    <td><%=r.getStatus() %></td>
  </tr>
  <%} // end loop %>
</table>

<%} // end of resolved %>
</center>
</body>
</html>