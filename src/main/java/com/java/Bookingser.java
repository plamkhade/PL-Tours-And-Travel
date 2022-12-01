package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Bookingser")
public class Bookingser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String n=request.getParameter("name");
		String a=request.getParameter("adharNo");
        String e=request.getParameter("email");
        String p=request.getParameter("pass");
		String pc=request.getParameter("packages");
		
	
    Bookbean b=new Bookbean();
    b.setName(n);
    b.setAdharNo(a);
    b.setEmail(e);
    b.setPass(p);
    b.setPackages(pc);
    
  
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pl","root","" );
		PreparedStatement ps=con.prepareStatement("insert into booking values(?,?,?,?,?)");
		
		ps.setString(1,n);
		ps.setString(2, a);
		ps.setString(3, e);
		ps.setString(4, p);
		ps.setString(5, pc);
		
	
		int k=ps.executeUpdate();
		if(k>0)
		{
			
			pw.print("<center><h2 style='color: blue; padding:40px;margin-top:250px;'>Booked Sucessfully!...<br><br>Thank You For Travelling With Us!... </h2></center>");
			pw.print("<body style='background-image: url(./resources//images//lg.webp);background-repeat: no-repeat;background-size: cover;'>");
			
			
			
			pw.print("<a href='index.html'><center><button style='border: none; color: white;padding: 15px 32px;text-align: center;text-decoration: none;font-size: 16px; margin: 4px 2px;cursor: pointer;background-color: green;'>Home</button></a> <a href='LogOut'><button style='border: none; color: white;padding: 15px 32px;text-align: center;text-decoration: none;font-size: 16px; margin: 4px 2px;cursor: pointer;background-color: green;'type=\"button\">Log out</button></center></a>");
			pw.print("<a href='PackageBook.jsp'><center><button style='border: none; color: white;padding: 15px 32px;text-align: center;text-decoration: none;font-size: 16px; margin: 4px 2px;cursor: pointer;background-color: green;'>Show booking</button></a> ");	
			
			
		}
		else {
			pw.print("error");
		}
	}
	catch(Exception e1){
		System.out.println(e1);
	}
	
	}

}

