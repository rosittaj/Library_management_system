<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issue Book</title>
 <link rel="stylesheet" href="css/formStyle.css">
</head>
<body>
<center>
<h3>Issue Book Form<a href="adminHome.jsp">Back to home</a></h3><br><br>


<form action="IssueBook" method="post">
      <label>Issue Date:</label>
           <input type="date" name="issuedate">&#160;&#160;&#160;&#160;&#160;&#160;&#160;
      <label>Return Date:</label>
           <input type="date" name="returndate"><br>
           <input type="text" name="issueid" placeholder="Book Issue Id"><br>
           <input type="number" name="bid" placeholder="Book Id"><br>
           <input type="number" name="sid" placeholder="Student Id"><br>
           <input type="text" name="name" placeholder="Student Name"><br>
           <input type="number" name="number" placeholder="Phone Number"><br>
           <input type="submit" name="submit" value="Issue Book">
</form>

</center>
</body>
</html>