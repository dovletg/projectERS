<%@page import="com.ers.model.Reimbursment"%>
<%@page import="com.ers.services.ReimbursmentService"%>
<%@page import="com.ers.model.User"%>
<%@page import="com.ers.services.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee requests</title>
</head>
<body>
<center>
<h1>Expense Reimbursement System</h1>
<br/>
<br/>
<br/>

<%
	String action = request.getParameter("action");

if("search".equalsIgnoreCase(action)){
	

%>

<h3>Search</h3>
<form action="view_emp_requests.jsp?action=view" method="post">

  <div class="container">
    <label for="uname"><b>User Id</b></label>
    <input type="number" placeholder="Enter User Id" name="userId" required>
	<br/>
	<br/>
    
    <br/>
    <br/>
    <button type="submit">View Requests</button>
  </div>

</form>
<%} // end of search
else if("view".equalsIgnoreCase(action)){
	int id = Integer.parseInt(request.getParameter("userId"));
	UserService userService = new UserService();
	ReimbursmentService rbs = new ReimbursmentService();
	
	User u = userService.getUserById(id);
%>
<h3><%=u.getUserName() %> Reimbursments</h3>
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
  for(Reimbursment r: rbs.getAllReimbursmentsByAuthorId(u.getId())){
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
<%} // end of view %>
</center>
</body>
</html>