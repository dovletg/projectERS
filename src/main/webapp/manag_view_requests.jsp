
<%@page import="com.ers.services.UserService"%>
<%@page import="java.util.List"%>
<%@page import="com.ers.model.Reimbursment"%>
<%@page import="com.ers.model.User"%>
<%@page import="com.ers.services.ReimbursmentService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Requests</title>

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

if("all_pending".equalsIgnoreCase(action)){
%>
<h2>Employee Pending Requests</h2>
<br>

<table border="1px">
  <tr>
    <th>Reimbursment ID</th>
    <th>User ID</th>
    <th>Title</th>
    <th>Description</th>
    <th>Submitted At</th>
    <th>Status</th>
  </tr>
  <% // fill pending requests table
  for(Reimbursment r: rb.getAllPendingReimbursments()){
  %>
  <tr>
    <td><%=r.getId() %></td>
    <td><%=r.getUser().getId() %></td>
    <td><%=r.getTitle() %></td>
    <td><%=r.getDescription() %></td>
    <td><%=r.getSubmitted().toString() %></td>
    <td><%=r.getStatus() %></td>
  </tr>
  <%} // end loop %>
</table>

<%}// end of pending 
else if("all_resolved".equalsIgnoreCase(action)){
%>

<h2>Employee Resolved Requests</h2>
<br>

<table border="1px">
  <tr>
    <th>Reimbursment ID</th>
    <th>User ID</th>
    <th>Title</th>
    <th>Description</th>
    <th>Resolved By</th>
    <th>Submitted At</th>
    <th>Resolved At</th>
    <th>Status</th>
  </tr>
  <% // fill pending requests table
  for(Reimbursment r: rb.getAllResolvedReimbursments()){
  %>
  <tr>
    <td><%=r.getId() %></td>
    <td><%=r.getUser().getId() %></td>
    <td><%=r.getTitle() %></td>
    <td><%=r.getDescription() %></td>
    <td><%=r.getResolvedBy()%></td>
    <td><%=r.getSubmitted().toString() %></td>
    <td><%=r.getResolved().toString() %></td>
    <td><%=r.getStatus() %></td>
  </tr>
  <%} // end loop %>
</table>

<%} // end of resolved 
else if("view_employees".equalsIgnoreCase(action)){
	UserService userService = new UserService();
	
%>
<h2>All Employee</h2>
<br>

<table border="1px">
  <tr>
    <th>User ID</th>
    <th>User Name</th>
    <th>Password</th>
    <th>Type</th>
    
  </tr>
  <% // fill pending requests table
  for(User r: userService.getAllUsers()){
  %>
  <tr>
    <td><%=r.getId() %></td>
    <td><%=r.getUserName() %></td>
    <td><%=r.getPassword() %></td>
    <td><%=r.getType() %></td>
  </tr>
  <%} // end loop %>
</table>
<%}// end of view employees %>
</center>
</body>
</html>