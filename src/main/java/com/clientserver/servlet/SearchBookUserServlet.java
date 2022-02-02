package com.clientserver.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.clientserver.dao.DBUtil;
import com.clientserver.dto.Book;

@WebServlet("/SearchBookUserServlet")
public class SearchBookUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session=request.getSession(); 
		 List<Book> books=new ArrayList<Book>();
		 
		 final String name =request.getParameter("name"); 
		 final String category =request.getParameter("category");
		
		 Book book=new Book();
		 book.setName(name); 
		 book.setCategory(category);
		 books = DBUtil.getAllBooks(name,category); 
		 
		 if(books!=null) {
		    request.setAttribute("books", books);
		    RequestDispatcher rd = request.getRequestDispatcher("searchBookUser.jsp");
		    rd.forward(request, response);
		 } 
		 else { 
			response.sendRedirect("userHome.jsp"); 
			 }
	}

}
