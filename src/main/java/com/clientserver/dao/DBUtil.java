package com.clientserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clientserver.dto.Book;
import com.clientserver.dto.IssueBook;
import com.clientserver.dto.Login;
import com.clientserver.dto.Person;




public class DBUtil {
	static int rowCount;
	
	//Check login details
	
	public static Login getUser(String userName, String password) throws SQLException {

		String sql = "Select username, password, display_name, user_type, person_person_id  from LOGIN_DETAIL" //
				+ " where username = ? and password= ?";
		Connection conn;
		try {
			conn = MySqlConnection.getMySqlConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, userName);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			Login user;
			if (rs.next()) {
				String displayName = rs.getString("display_name");
				String userType = rs.getString("user_type");
				user = new Login();
				user.setUsername(userName);
				user.setPassword(password);
				user.setDisplayName(displayName);
				user.setUserType(userType);
				Person person = getPerson(conn, rs.getInt("person_person_id"));
				user.setPerson(person);
				return user;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

		return null;
	}
	
  //Take values from user table for login 
	
	public static Person getPerson(Connection conn, int personId) throws SQLException {
		String sql = "Select person_id, first_name, last_name from PERSONS "//
				+ " where person_id = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, personId);

		ResultSet rs = pstm.executeQuery();
		Person person = null;
		if (rs.next()) {
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			
			person = new Person();
			person.setFirstName(firstName);
			person.setLastName(lastName);
			
			person.setPersonId(personId);
		}
		return person;
	}
	
	
//Add new book to DB
	
	public static int addBook(Book book) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			
			String sql = "insert into book(bookName,authorName,category,publishedYear) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, book.getName());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getCategory());
			ps.setString(4, book.getYear());
		
			rowCount=ps.executeUpdate();
			ConnectionUtil.close(con);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.print(e);
		}
	return rowCount;
	}
	
//Get all the searched book from DB.Checking on the basis of book name and category
	
	public static List<Book> getAllBooks( String name, String category){
		   List<Book> books=new ArrayList<Book>();
		    
		   try {
			   
			   Connection con = ConnectionUtil.getConnection();
			   String query="select * from book where bookName=? and category=?";
			   PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, name); 
				ps.setString(2, category);
				 
			   ResultSet rs=ps.executeQuery();
			   while(rs.next()) {
				   Book row=new Book();
				   
				   row.setIdbook(rs.getInt("idbook"));
				   row.setName(rs.getString("bookName"));
				   row.setAuthor(rs.getString("authorName"));
				   row.setCategory(rs.getString("category"));
				   row.setYear(rs.getString("publishedYear"));
				   
				   books.add(row);
				   
			   }
			   
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   return books;
	   }
	   
//Get all the book details from DB
	
	public static List<Book> showBook(){
		   List<Book> books=new ArrayList<Book>();
		    
		   try {
			   
			   Connection con = ConnectionUtil.getConnection();
			   String query="select * from book ";
			   PreparedStatement ps=con.prepareStatement(query);
				
				 
			   ResultSet rs=ps.executeQuery();
			   while(rs.next()) {
				   Book row=new Book();
				  
				   row.setIdbook(rs.getInt("idbook"));
				   row.setName(rs.getString("bookName"));
				   row.setAuthor(rs.getString("authorName"));
				   row.setCategory(rs.getString("category"));
				   row.setYear(rs.getString("publishedYear"));
				   
				   books.add(row);
				   
				   
			   }
			   
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   return books;
	   }

	

	//show all users in admin page
	public static List<Person> showUser(){ Connection con; List<Person>
	  person=new ArrayList<Person>(); try { con = ConnectionUtil.getConnection();
	String query="select * from persons"; PreparedStatement
	ps=con.prepareStatement(query); ResultSet rs=ps.executeQuery();
	 while(rs.next()) { Person row=new Person();
	 row.setPersonId(rs.getInt("person_id"));
	 row.setFirstName(rs.getString("first_name"));
	 row.setMiddleName("middle_name"); row.setLastName(rs.getString("last_name"));
	 person.add(row); }
	
	 } catch(Exception e) { e.printStackTrace(); }
	

	 return person;
	 
	  }
	
		
//Admin issue a book for user	
	  
	  public static int issueBook(IssueBook issuebook) {
			Connection con;
			try {
				con = ConnectionUtil.getConnection();
					   String sql = "insert into issuebook(issuedate,returndate,idbook,person_id,first_name,phone,issueid,status) values(?,?,?,?,?,?,?,'No')";
					   PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, issuebook.getIssuedate());
						ps.setString(2, issuebook.getReturndate());
						ps.setString(3, issuebook.getIdbook());
						ps.setString(4, issuebook.getPerson_id());
						ps.setString(5, issuebook.getFirst_name());
						ps.setString(6, issuebook.getPhone());
						ps.setString(7, issuebook.getIssueid());
						rowCount=ps.executeUpdate();
						ConnectionUtil.close(con);
				

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				System.out.print(e);
			}
		return rowCount;
		}
		
//Show issued books of a particular student
	  
	  public static List<IssueBook> showIssuedBooksUser(int id){
		   List<IssueBook> issuebook=new ArrayList<IssueBook>();
		    
		   try {
			   
			   Connection con = ConnectionUtil.getConnection();
			   String query="select * from issuebook where person_id=?";
			   PreparedStatement ps=con.prepareStatement(query); 
			   ps.setInt(1, id);
			   ResultSet rs=ps.executeQuery();
				 while(rs.next()) { 
					 IssueBook row=new IssueBook();
				 row.setIdbook(rs.getString("idbook"));		
				 row.setPerson_id(rs.getString("person_id"));
			     row.setIssuedate(rs.getString("issuedate"));
			     row.setReturndate(rs.getString("returndate"));
			   
			     row.setIssueid(rs.getString("issueid"));
			     row.setStatus(rs.getString("status"));
			     row.setFineamount(rs.getInt("fineamount"));
			     issuebook.add(row); 
			   
				 }
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   return issuebook;
	   } 
	  
//All issued book shown in admin page
	  
	  public static List<IssueBook> showIssuedBooksAdmin(){
		   List<IssueBook> issuebook=new ArrayList<IssueBook>();
		    
		   try {
			   
			   Connection con = ConnectionUtil.getConnection();
			   String query="select * from issuebook";
			   PreparedStatement ps=con.prepareStatement(query); 
		
			   ResultSet rs=ps.executeQuery();
				 while(rs.next()) { 
				 IssueBook row=new IssueBook();
				 row.setIdbook(rs.getString("idbook"));		
				 row.setPerson_id(rs.getString("person_id"));
			     row.setIssuedate(rs.getString("issuedate"));
			     row.setReturndate(rs.getString("returndate"));
			     row.setFirst_name(rs.getString("first_name"));
			     row.setPhone(rs.getString("phone"));
			     row.setIssueid(rs.getString("issueid"));	
			     row.setStatus(rs.getString("status"));
			     issuebook.add(row); 
			   
				 }
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   return issuebook;
	   } 
	  
	  public static int returnBook(IssueBook issuebook) {
			Connection con;
			try {
				con = ConnectionUtil.getConnection();
					   String sql = "update issuebook set status='Yes' where issueid=? and person_id=?";
					   PreparedStatement ps = con.prepareStatement(sql);
						
						ps.setString(1, issuebook.getIssueid());
						ps.setString(2, issuebook.getPerson_id());
						rowCount=ps.executeUpdate();
						ConnectionUtil.close(con);
				

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				System.out.print(e);
			}
		return rowCount;
		}
	  
	 
	  public static int renewBook(IssueBook issuebook) {
			Connection con;
			try {
				con = ConnectionUtil.getConnection();
					   String sql = "update issuebook set status='No',fineamount=fineamount+10 where issueid=? and status='No'";
					   PreparedStatement ps = con.prepareStatement(sql);
						
						ps.setString(1, issuebook.getIssueid());
		
						rowCount=ps.executeUpdate();
						ConnectionUtil.close(con);
				

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				System.out.print(e);
			}
		return rowCount;
		}
	  
	  
	  
	  
	  
	  
	
	}

