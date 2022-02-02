<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.clientserver.dao.*"%>
<%@ page import="com.clientserver.dto.*"%>
<%@ page import="com.clientserver.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search Book</title>
<link rel="stylesheet" href="css/formStyle.css">
</head>
<body>
<center>
<h5>Search book <a href="adminHome.jsp">Back To Home</a></h5>
<form action="SearchBookSetvlet">

<input type="text" name="name">
<input type="text" name="category">
<input type="submit" name="submit" value="submit">
</form>	
</center>

<% List<Book> books=(List<Book>)request.getAttribute("books"); %>
<%
if (session.getAttribute("name") == null) {
	response.sendRedirect("login.jsp");
}
%>
 
<%
if(books!=null){ %>
	
	<table>
	  <tr>
	    <th>Book Name</th>
	    <th>Author</th>
	    <th>Category</th>
	    <th>Published Year </th>
	   
	  </tr>
	
	<% for(Book b:books){ %>
	<tr>
    <td> <%= b.getName() %></td>
    <td> <%= b.getAuthor() %></td>
    <td> <%= b.getCategory() %></td>
    <td> <%= b.getYear() %></td>
 				
	<% }
 }%>
 
</body>
</html>