package com.clientserver.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clientserver.dao.DBUtil;
import com.clientserver.dto.IssueBook;

public class IssueBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String issueid=request.getParameter("issueid");
		final String issuedate=request.getParameter("issuedate");
		final String returndate=request.getParameter("returndate");
		final String sid=request.getParameter("sid");
		final String  bid=request.getParameter("bid");
		final String name=request.getParameter("name");
		final String number=request.getParameter("number");
		
		IssueBook issuebook=new IssueBook();
		
		issuebook.setIssueid(issueid);
		issuebook.setIssuedate(issuedate);
		issuebook.setReturndate(returndate);
		issuebook.setIdbook(bid);
		issuebook.setPerson_id(sid);
		issuebook.setFirst_name(name);
		issuebook.setPhone(number);
		
		int rowCount=DBUtil.issueBook(issuebook);
		if(rowCount>0) {
			response.sendRedirect("adminHome.jsp");
		}
		else {
			response.sendRedirect("error.jsp");;
		}
		
	}

}
