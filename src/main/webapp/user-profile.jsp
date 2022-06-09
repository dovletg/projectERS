<%@page import="com.ers.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Expense Reimbursement System</h1>
<br/>
<br/>

<%
String action = request.getParameter("action");
User user = (User) request.getSession().getAttribute("user");
if("view_info".equalsIgnoreCase(action)){
%>
	<h3>View User Information</h3>
	<table border="1px">
	  <tr>
	    <th>ID</th>
	    <th>User Name</th>
	    <th>Password</th>
	    <th>Type</th>
	    
	  </tr>
	  <tr>
	  	<td><%= user.getId()%></td>
	  	<td><%= user.getUserName()%></td>
	  	<td><%= user.getPassword()%></td>
	  	<td><%= user.getType()%></td>
	  </tr>
  </table>
<%
}else if("update_info".equalsIgnoreCase(action)){
	

%>

<h3>Update User Information</h3>
<form action="UserController?action=update" method="post">

 <input type="number" name="id" value="<%=user.getId() %>" hidden/>
  <div class="container">
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="uname" value="<%=user.getUserName() %>" required>
	<br/>
	<br/>
    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" value="<%=user.getPassword() %>" required>
    
    <br/>
    <br/>
    <button type="submit">Update information</button>
  </div>

</form>

<%} // end of update info %>
</center>
</body>
</html>