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
<title>Issued Books</title>
<link rel="stylesheet" href="css/formStyle.css">
</head>
<body>
<%
if (session.getAttribute("name") == null) {
	response.sendRedirect("login.jsp");
}
%>
<%   
int id=(int)session.getAttribute("id");	
DBUtil db=new DBUtil();		
List<IssueBook> issuebook = DBUtil.showIssuedBooksUser(id);
%>

<a href="userHome.jsp" >Back to home</a>
<table>
  <tr>
  <th>Issue ID</th>
    <th>Book ID</th>
    <th>Person ID</th>
    <th>Issued Date</th>
    <th>Return Date </th>
    <th>Return Status</th>
    <th>Renew</th>
    <th>Fine Amount</th>
    
   
  </tr>
  
<%
if(!issuebook.isEmpty()){ 
	
	for(IssueBook b:issuebook){ %>
	<tr>
	 <td> <%= b.getIssueid() %></td>
    <td> <%= b.getIdbook() %></td>
    <td> <%= b.getPerson_id() %></td>
    <td> <%= b.getIssuedate() %></td>
    <td> <%= b.getReturndate() %></td>
    <td> <%= b.getStatus() %></td>
    
    <td><a href="RenewBookServlet?id=<%= b.getIssueid() %>"">Renew</a></td>
   <td> <%= b.getFineamount() %></td>
    
 				
	<% }
 }%>
  </tr>
 </table>
</body>
</html>