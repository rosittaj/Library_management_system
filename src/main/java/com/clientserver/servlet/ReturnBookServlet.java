package com.clientserver.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clientserver.dao.DBUtil;
import com.clientserver.dto.IssueBook;

/**
 * Servlet implementation class ReturnBookServlet
 */
@WebServlet("/ReturnBookServlet")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		final String issueid=request.getParameter("issueid");
		final String sid=request.getParameter("sid");
		
		IssueBook issuebook=new IssueBook();
		issuebook.setIssueid(issueid);
		issuebook.setPerson_id(sid);
		int rowCount=DBUtil.returnBook(issuebook);
		if(rowCount>0) {
			response.sendRedirect("adminHome.jsp");
		}
		else {
			response.sendRedirect("error.jsp");;
		}
	}

	

}
