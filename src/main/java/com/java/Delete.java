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

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String i = request.getParameter("id");

		Bean b1 = new Bean();
		b1.setId(i);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pl", "root", "");
			PreparedStatement ps = con.prepareStatement("delete from details where id=?");
			ps.setString(1, i);

			int k = ps.executeUpdate();
			if (k > 0) {
				
				
				pw.print("<center><h2 style='color: blue; padding:40px; margin-top:250px;'>Sucessfully Deleted!... </h2></center>");
				
                pw.print("<body style='background-image: url(./resources//images//lg.webp);background-repeat: no-repeat;background-size: cover;'>");
				
				pw.print("<a href='index.html'><center><button style='border: none; color: white;padding: 15px 32px;text-align: center;text-decoration: none;font-size: 16px; margin: 4px 2px;cursor: pointer;background-color: green;'>Home</button></center></a>");
						
				
				
			} else {
				pw.print("error");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
