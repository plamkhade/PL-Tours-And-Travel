package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Loginser")
public class Loginser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String n=request.getParameter("email");
		String p=request.getParameter("psw");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pl","root","" );
			
			PreparedStatement ps=con.prepareStatement("select email,psw from details where email=? and psw=?");
			ps.setString(1, n);
			ps.setString(2, p);
			ResultSet rs=ps.executeQuery();
			System.out.println(rs.getFetchSize());
			
			if(rs.next())
			{
				System.out.println(rs.getString(1));
				if(n.equals(rs.getString(1)) && p.equals(rs.getString(2)))
             {
                    pw.print("<center><h2 style='color: blue; padding:40px;margin-top:230px;'>Login Sucessfully </h2></center>");
					
	                pw.print("<body style='background-image: url(./resources//images//lg.webp);background-repeat: no-repeat;background-size: cover;'>");
					
					
					pw.print("<a href='Delete.html'><center><button style='border: none; color: white;padding: 15px 32px;text-align: center;text-decoration: none;font-size: 16px; margin: 4px 2px;cursor: pointer;background-color: green;width:20%;'>Delete</button></a> <a href='Update.html'><button style='border: none;width:20%; color: white;padding: 15px 32px;text-align: center;text-decoration: none;font-size: 16px; margin: 4px 2px;cursor: pointer;background-color: green;'type=\"button\">Update</button></center></a>");		
					
					pw.print("<a href='show.jsp'><center><button style='border: none; color: white;padding: 15px 32px;text-align: center;text-decoration: none;font-size: 16px; margin: 4px 2px;cursor: pointer;background-color: green; width:20%;'>Show Detail</button></a> <a href='Package.html'><button style='border: none; width:20%; color: white;padding: 15px 32px;text-align: center;text-decoration: none;font-size: 16px; margin: 4px 2px;cursor: pointer;background-color: green;'type=\"button\">Packages</button></center></a>");		
					
					
					
               }
               else {
	         pw.print("incorect password");
               }
				
			}
		}
	
	catch(Exception e)
	{
		System.out.println(e);
	}

	}
}
