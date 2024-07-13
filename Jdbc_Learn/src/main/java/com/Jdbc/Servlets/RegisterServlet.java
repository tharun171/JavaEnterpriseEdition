package com.Jdbc.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.Jdbc.Entities.EmployeeEntity;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//HttpSession session = request.getSession();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbcall";
			String username = "root";
			String password = "Tharun@1701";
			
			//Getting registration details from Register.jsp
			String name = request.getParameter("RegName");
			String email = request.getParameter("RegEmail");
			String pass = request.getParameter("RegPassword");
			
			EmployeeEntity emp = new EmployeeEntity();
			emp.setEmpEmail(email);
			emp.setEmpName(name);
			emp.setEmpPassword(pass);
			System.out.println("Registered Details -> "+emp.toString());
			
			//Establishing Connection
			Connection conn = DriverManager.getConnection(url,username,password);
			//Checking whether email exist in DB or not
			String query = "select * from servletauthweb where empEmail=?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			//ordinal start with 1
			ps.setString(1,email);
			
			ResultSet rs = ps.executeQuery();
			//if theres a row, email already exist and rs.next() will be true
			if(rs.next())
			{
				System.out.println("email exist in database");
				//go back to registration page i.e; index.jsp
				RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
				request.setAttribute("status","Account already exist! Login Below!");
				//To print Register here Message dynamically
				//If name value is null, it will show Register here in index page
				request.setAttribute("name","something");
				rd.include(request, response);
				rd.forward(request, response);
			}
			else
			{
				String query1 = "insert into servletauthweb values(?,?,?,?)";
				ps = conn.prepareStatement(query1);
				//default id we are giving as 0
				ps.setInt(1, 0);
				ps.setString(2,emp.getEmpName());
				ps.setString(3,emp.getEmpEmail());
				ps.setString(4,emp.getEmpPassword());
				
				int rowsUpdated = ps.executeUpdate();
				System.out.println("no of rows updated "+rowsUpdated);
				RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
				request.setAttribute("status","Registration Success, Login now!");
				//To print Register here Message dynamically
				//If name value is null, it will show Register here in index page
				request.setAttribute("name","something");
				rd.include(request, response);
				rd.forward(request, response);
			}
			conn.close();
		}
		catch(ClassNotFoundException | SQLException ex)
		{
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
