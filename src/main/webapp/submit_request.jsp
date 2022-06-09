<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Submit reibmursment request</title>
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
<br/>
<h2>Submit Reimbursment Request</h2>
<br>
<form action="ReimbursmentController?action=add_request" method="post">
<table>
  
  <tr>
    <td><strong>Title </strong></td><td><input type="text" name="title"></input></td>
  </tr>
  <tr>
    <td><strong>Description </strong></td><td><textarea name="description" rows="4" cols="40"></textarea></td>
    
  </tr>
</table>

<br/>
<strong><button type="submit">Submit</button></strong>
</form>
</center>
</body>
</html>