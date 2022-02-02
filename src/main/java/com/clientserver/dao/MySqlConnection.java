package com.clientserver.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	
	
	public static Connection getMySqlConnection()
			 throws ClassNotFoundException, SQLException {
		
	     String hostName = "localhost";
	     String dbName = "librarymanagementsystem";
	     String userName = "root";
	     String password = "ViVo@2021";
	     Class.forName("com.mysql.jdbc.Driver");
		 
	     String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
	 
	     Connection con = DriverManager.getConnection(connectionURL, userName,
	             password);
	     return con;
	 }
	
	
	
	

}
