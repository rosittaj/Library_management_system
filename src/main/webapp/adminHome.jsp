<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="css/formStyle.css">
<title>Admin Home</title>
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
		<a  href="#home">Home</a>
		
		<a href="newBook.jsp">New Book</a>
        <a href="searchBookAdmin.jsp">search book</a>
        <a href="AllBooksAdmin.jsp">all books</a>
        <a href="issueBook.jsp">Issue Book</a>
        <a href="issueedBookAdmin.jsp">Issued Book</a>
        <a href="ReturnBook.jsp">Return Book</a>
       
 <!--  Logout -->     
       
        <form action="Logout">
			<button
				style="background-color: #66b3ff; border: none; color: white; padding: 5px; text-align: center; text-decoration: none; display: inline-block; font-size: 16px; margin: 10px 10px; float: right; border-radius: 50%;">
				Logout
			</button>
			<a href="#" style="float: right;"><%=session.getAttribute("name")%></a>
		</form>
	</div>
	
</body>
</html>