<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Return Book</title>
<link rel="stylesheet" href="css/formStyle.css">
</head>
<body>


<center>

<h5>Return Book Form <a href="adminHome.jsp">Back To Home</a></h5>

<form action="ReturnBookServlet" method="post"> 
     <input type="text" name="issueid" placeholder="Book Issue Id"><br>
     <input type="number" name="sid" placeholder="Student Id"><br>
     <input type="text" name="name" placeholder="Student Name"><br>
     <input type="submit" name="submit" value="Return Book">
</form>
</center>

</body>
</html>