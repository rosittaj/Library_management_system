<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%>
<%@ page import=" com.clientserver.dto.*"%>
<%@ page import="com.clientserver.dao.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>show search book</title>
 <link rel="stylesheet" href="css/formStyle.css">
</head>
<body>
<% String name=request.getParameter("name");
String category=request.getParameter("category");

if (session.getAttribute("name") == null) {
	response.sendRedirect("login.jsp");
}
		
List<Book> book = DBUtil.getAllBooks(name,category);
%>
<table>
  <tr>
    <th>Book Name</th>
    <th>Author</th>
    <th>Category</th>
    <th>Published Year </th>
  </tr>
<%
if(!book.isEmpty()){ 
	
	for(Book b:book){ %>
	<tr>
    <td> <%= b.getName() %></td>
    <td> <%= b.getAuthor() %></td>
    <td> <%= b.getCategory() %></td>
    <td> <%= b.getYear() %></td>
    						
	<% }
 }%>
</body>
</html>