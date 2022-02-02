<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.clientserver.dao.*"%>
<%@ page import="com.clientserver.dto.*"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/table.css">
<title>all users</title>
</head>
<body>
<!-- session  -->
<%
if (session.getAttribute("name") == null) {
	response.sendRedirect("login.jsp");
}
%>
 <%
List<Person> person = DBUtil.showUser();
%> 
<h3>All Users&#160;&#160;<a href="adminHome.jsp">home</a> </h3>

<table>
  <tr>
    <th>User Id</th>
    <th>First Name</th>
    <th>Last Name</th>
  </tr>
  
  <%
if(!person.isEmpty()){
	
	for(Person p:person){ %>
	<tr>
    <td> <%= p.getPersonId() %></td>
    <td> <%= p.getFirstName() %></td>
    <td> <%= p.getLastName() %></td>
    						
	<% }
}%>
  </tr>
 </table>

</body>
</html>