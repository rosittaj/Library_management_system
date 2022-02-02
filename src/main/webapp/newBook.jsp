<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>new book</title>
<link rel="stylesheet" href="css/formStyle.css">
</head>
<body>
<center>
<a href="adminHome.jsp">Back to home</a>

<form action="AddBookServlet" method="post">
    <input type="text" name="name" placeholder="Book Name"><br>
    <input type="text" name="author" placeholder="Author Name"><br>
    <input type="text" name="category" placeholder="Book Category"><br>
    <input type="text" name="year" placeholder="Published Year"><br>
    <input type="submit" name="submit" value="submit">
</form>
</center>

</body>
</html>