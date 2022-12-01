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


@WebServlet("/Update")
public class Update extends HttpServlet {
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
	
    Bean b=new Bean();
    b.setFirstname(i);
	b.setFirstname(f);
	b.setLastname(l);
	b.setCountry(c);
	b.setPhone(p);
	b.setEmail(e);
		
	   
	
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pl","root","" );
			PreparedStatement ps=con.prepareStatement("update details set firstname=?,lastname=?,country=?,address=?,phone=?,email=? where id=?");
			
			ps.setString(1, f);
			ps.setString(2, l);
			ps.setString(3, c);
			ps.setString(4, a);
			ps.setString(5, p);
			ps.setString(6, e);
			ps.setString(7, i);
		
			int k=ps.executeUpdate();
			if(k>0)
			{
				
				
               
				
                pw.print("<body style='background-image: url(./resources//images//lg.webp);background-repeat: no-repeat;background-size: cover;'>");
                pw.print("<a href='update.jsp'><center><button style='border: none;margin-top:50px; color: white;padding: 15px 32px;text-align: center;text-decoration: none;font-size: 16px; margin: 4px 2px;cursor: pointer;background-color: green; width:20%;'>Show update </button></a>");
                pw.print("<a href='Package.html'><button style='border: none; width:20%;margin-top:50px; color: white;padding: 15px 32px;text-align: center;text-decoration: none;font-size: 16px; margin: 4px 2px;cursor: pointer;background-color: green;'type=\"button\">Packages</button></center></a>");		
				
				
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