<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee homepage</title>

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

<h2>Employee Homepage</h2>
<br>

<table>
  
  <tr>
    <td><strong><a href="submit_request.jsp">Submit a reimbursement request</a></strong></td>
    <td><strong><a href="view_requests.jsp?action=pending">View pending reimbursement requests</a></strong></td>
  </tr>
  <tr>
    <td><strong><a href="view_requests.jsp?action=resolved">View resolved reimbursement requests</a></strong></td>
    <td><strong><a href="user-profile.jsp?action=view_info">View my information</a></strong></td>
  </tr>
  <tr>
    <td><strong><a href="user-profile.jsp?action=update_info">Update my information</a></strong></td>
    <td><strong><a href="login.jsp">Logout</a></strong></td>
  </tr>
</table>

</center>
</body>
</html>