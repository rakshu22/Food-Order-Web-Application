package food_order_webapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Statement;

@WebServlet("/adminlogin")
public class AdminLogin_Servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String code=req.getParameter("code");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/food_order_webapp", "root", "root");
			java.sql.Statement statement=connection.createStatement();
			ResultSet rs= statement.executeQuery("select * from admin_credentials");
			while(rs.next())
			{
				if(rs.getString("email").equals(email))
				{
					//correct email >>check password
					if(rs.getString("password").equals(password))
					{
						//correct password >>check security code
						if(rs.getString("code").equals(code))
						{
							//correct security code >>login success
							req.setAttribute("email",rs.getString("email"));
							RequestDispatcher dispatcher=req.getRequestDispatcher("admin_home.jsp");
							dispatcher.forward(req, resp);
						}else
						{
							//wrong security code >>send a message
							req.setAttribute("message", "Invalid security code");
							RequestDispatcher dispatcher=req.getRequestDispatcher("admin_login.jsp");
							dispatcher.include(req, resp);
						}
					}else
					{
						//wrong password >> send a message
						req.setAttribute("message", "Invalid password");
						RequestDispatcher dispatcher=req.getRequestDispatcher("admin_login.jsp");
						dispatcher.include(req, resp);
					}
				}else
				{
					//wrong email >>send a message
					req.setAttribute("message", "Invalid email");
					RequestDispatcher dispatcher=req.getRequestDispatcher("admin_login.jsp");
					dispatcher.include(req, resp);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
