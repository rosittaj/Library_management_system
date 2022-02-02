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
 <link rel="stylesheet" href="css/formStyle.css">
<title>User home</title>
</head>
<body>

<!-- Session for current user -->

<%
if (session.getAttribute("name") == null) {
	response.sendRedirect("login.jsp");
}
%>
<!-- Top nav -->
	<div class="topnav">
		<a  href="#home">Home</a> <a href="#news">News</a> 
		<a href="#contact">Contact</a> 
		 <a href="AllBooksUser.jsp">all books</a>
		 <a href="searchBookUser.jsp">Search book</a>
		  <a href="issuedBookUser.jsp">Issued book</a>
       
        <form action="Logout">
			<button
				style="background-color: #66b3ff; border: none; color: white; padding: 5px; text-align: center; text-decoration: none; display: inline-block; font-size: 16px; margin: 10px 10px; float: right; border-radius: 50%;">
				Logout
			</button>
			<a href="userHome.jsp" style="float: right;"><%=session.getAttribute("name")%></a>
			
		</form>
	</div>

	
</body>
</html>