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
<title>Insert title here</title>
 <link rel="stylesheet" href="css/formStyle.css">
</head>
<body>

<%   
DBUtil db=new DBUtil();		
List<Book> books = DBUtil.showBook();
%>
<a href="userHome.jsp" >Back to home</a>
<table>
  <tr>
 
    <th>Book Name</th>
    <th>Author</th>
    <th>Category</th>
    <th>Published Year </th>
   
  </tr>
  
<%
if(!books.isEmpty()){ 
	
	for(Book b:books){ %>
	<tr>
    <td> <%= b.getName() %></td>
    <td> <%= b.getAuthor() %></td>
    <td> <%= b.getCategory() %></td>
    <td> <%= b.getYear() %></td>
 				
	<% }
 }%>
  </tr>
 </table>
</body>
</html>