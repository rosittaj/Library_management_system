package com.clientserver.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import com.clientserver.dao.DBUtil;
import com.clientserver.dto.Login;
import com.clientserver.utils.Constants;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		HttpSession session=request.getSession();
		
		Login login = null;
		try {
			login = DBUtil.getUser(username, password);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	    if(login == null) {
		   response.sendRedirect("error.jsp");
	      }
	      
	//as a admin
	    
	    else if(Constants.USER_TYPE_ADMIN.equals(login.getUserType())){
		     session.setAttribute("name", login.getUsername());
		
		     response.sendRedirect("adminHome.jsp");
	        }
	//as a student
	    
	   else if(Constants.USER_TYPE_TRAINEER.equals(login.getUserType())){
	     	session.setAttribute("id", login.getPerson().getPersonId());
	    	session.setAttribute("name", login.getUsername());
		   response.sendRedirect("userHome.jsp");
	     }
	
	   response.getWriter().close();
}
	
}
