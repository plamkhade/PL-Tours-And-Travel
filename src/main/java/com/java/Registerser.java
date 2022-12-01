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
import java.sql.*;



@WebServlet("/Registerser")
public class Registerser extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String i=request.getParameter("id");
		String f=request.getParameter("firstname");
        String l=request.getParameter("lastname");
        String c=request.getParameter("country");
		String a=request.getParameter("address");
		String p=request.getParameter("phone");
		String e=request.getParameter("email");
		String pp=request.getParameter("psw");
	
    Bean b=new Bean();
    b.setFirstname(i);
	b.setFirstname(f);
	b.setLastname(l);
	b.setCountry(c);
	b.setPhone(p);
	b.setEmail(e);
	b.setPsw(pp);
	   
	
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pl","root","" );
			PreparedStatement ps=con.prepareStatement("insert into details values(?,?,?,?,?,?,?,?)");
			
			ps.setString(1,i);
			ps.setString(2, f);
			ps.setString(3, l);
			ps.setString(4, c);
			ps.setString(5, a);
			ps.setString(6, p);
			ps.setString(7, e);
			ps.setString(8, pp);
		
			int k=ps.executeUpdate();
			if(k>0)
			{
				
				pw.print("<center><h2 style='color: red;margin-top:300px; padding:40px;'>Registered Sucessfully </h2></center>");
				pw.print("<body style='background-image: url(./resources//images//lg.webp);background-repeat: no-repeat;background-size: cover;'>");
				
				pw.print("<a href='Login.html'><center><button style='border: none; width:20%; color: white;padding: 15px 32px;text-align: center;text-decoration: none;font-size: 16px; margin: 4px 2px;cursor: pointer;background-color: green;'>Log In</button></a>");		
				
				
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
