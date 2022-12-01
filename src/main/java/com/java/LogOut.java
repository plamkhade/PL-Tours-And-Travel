package com.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");  
          PrintWriter out=response.getWriter();  
            
          request.getRequestDispatcher("link.html").include(request, response);  
            
          HttpSession session=request.getSession();  
          session.invalidate();  
            
        
          out.print("<body style='background-image: url(./resources//images//lg.webp);background-repeat: no-repeat;background-size: cover;'>");
          out.print("<center><h2 style='color: blue; padding:40px;margin-top:250px;'>Are you sure you want to log out...</h2></center><br><br>");
          		   
			
       out.print("<a href='index.html'><center><button style='border: none; width:20%; color: white;padding: 15px 32px;text-align: center;text-decoration: none;font-size: 16px; margin: 4px 2px;cursor: pointer;background-color: green;width:20%'>Yes</button></a> <a href='index.html'><button style='border: none; width:20%; color: white;padding: 15px 32px;text-align: center;text-decoration: none;font-size: 16px; margin: 4px 2px;cursor: pointer;background-color: green;'type=\"button\">No</button></center></a>");		
			
					out.close(); 
    

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	 
	      


	    }
	

