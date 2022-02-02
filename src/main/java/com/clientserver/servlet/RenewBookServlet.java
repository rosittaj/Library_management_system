package com.clientserver.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clientserver.dao.DBUtil;
import com.clientserver.dto.IssueBook;

@WebServlet("/RenewBookServlet")
public class RenewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String issueid=request.getParameter("id");
		
		IssueBook issuebook=new IssueBook();
		issuebook.setIssueid(issueid);
		
		int rowCount=DBUtil.renewBook(issuebook);
		
		if(rowCount>0) {
			response.sendRedirect("issuedBookUser.jsp");
		}
		else {
			response.sendRedirect("error.jsp");;
		}
		
	}
}
