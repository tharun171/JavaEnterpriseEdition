package com.Jdbc.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Jdbc.Entities.EmployeeEntity;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//HttpSession sess = request.getSession();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbcall";
			String username = "root";
			String password = "Tharun@1701";
			
			//Getting Login details from Login.jsp
			//after user enetered details in Login.jsp
			String email = request.getParameter("loginEmail");
			String pass = request.getParameter("loginPassword");
			
			//Establishing Connection
			Connection conn = DriverManager.getConnection(url,username,password);
			//empEmail and empPassword are names from database tables;
			//BINARY makes password case-sensitive
			String query = "select * from servletauthweb where empEmail=? and BINARY empPassword=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,email);
			ps.setString(2,pass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				System.out.println("user exist in database");
				//Show login success in LoginSuccess.jsp
				//Getting user details
				Integer id = rs.getInt("empId");
				String name = rs.getString("empName");
				String userEmail = rs.getString("empEmail");
				String userPass = rs.getString("empPassword");
				System.out.println(id+" "+name+" "+userEmail+" "+userPass);
				
				EmployeeEntity emp = new EmployeeEntity(id,name,userEmail,userPass);
				request.setAttribute("emp",emp);
				request.setAttribute("loginStatus","Hi, "+name);
				
				RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess.jsp");
				request.setAttribute("successMessage","Login Success");
				rd.include(request, response);
				rd.forward(request, response);
				System.out.println("--Done--");
			}
			else
			{
				System.out.println("user credentials wrong");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				request.setAttribute("email","email");
				request.setAttribute("loginStatus","Wrong Login Credentials");
				rd.include(request, response);
				rd.forward(request, response);
			}
			conn.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getLocalizedMessage());
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
