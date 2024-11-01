package com.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

public class UsersDatabase extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		// server input
		int id = Integer.parseInt(req.getParameter("userId"));
		String name = req.getParameter("userName");
		String email = req.getParameter("userEmail");
		String address = req.getParameter("userAddress");
		
		PrintWriter writer = res.getWriter();
		
		// jdbc logic
		final String URL = "jdbc:mysql://localhost:3306/userdatabase?user=root&password=root";
		final String INSERTQUERY = "insert into users(userId, userName, userEmail, userAddress) values(?, ?, ?, ?);";
		final String FETCHQUERY = "select * from users;";
		
		try {
			// load & register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Establish the Connection
			Connection con = DriverManager.getConnection(URL);
			
			// Creating the statement
			PreparedStatement pstmt = con.prepareStatement(INSERTQUERY);
			Statement stmt = con.createStatement();
			
			// Process the data
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, address);
			
			// Execute the Query
			pstmt.executeUpdate();
			
			ResultSet rs = stmt.executeQuery(FETCHQUERY);
			
			writer.println("<h1>User Details: </h1>");
			writer.println("<h1>--------------------------------------------</h1>");
			while(rs.next())
			{
				int uId = rs.getInt(1);
				String uName = rs.getString(2);
				String uEmail = rs.getString(3);
				String uAddress = rs.getString(4);
				
				writer.println("<h1>"+uId+" - "+uName+" - "+uEmail+" - "+uAddress+"</h1>");
				
			}
			
			stmt.close(); pstmt.close(); con.close();
		}
		catch(Exception e) { 
			writer.println("<h1>"+e.getMessage()+"</h1>");
		}
		
	}

}

