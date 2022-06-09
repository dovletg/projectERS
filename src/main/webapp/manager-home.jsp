<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager homepage</title>

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

<h2>Manager Homepage</h2>
<br>

<table>
  
  <tr>
    <td><strong><a href="approve_request.jsp">Approve/Deny pending reimbursement requests</a></strong></td>
    <td><strong><a href="manag_view_requests.jsp?action=all_pending">View all pending requests of all employees</a></strong></td>
  </tr>
  <tr>
    <td><strong><a href="manag_view_requests.jsp?action=all_resolved">View all resolved requests of all employees</a></strong></td>
    <td><strong><a href="view_emp_requests.jsp?action=search">View reimbursement requests of a specific employee</a></strong></td>
  </tr>
  <tr>
    <td><strong><a href="manag_view_requests.jsp?action=view_employees">View all employees</a></strong></td>
    <td><strong><a href="login.jsp">Logout</a></strong></td>
  </tr>
</table>

</center>
</body>
</html>