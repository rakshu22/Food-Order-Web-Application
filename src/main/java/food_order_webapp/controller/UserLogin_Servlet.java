package food_order_webapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_order_webapp.dao.UserDao;
import food_order_webapp.dto.User;

@WebServlet("/login")
public class UserLogin_Servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		UserDao userDao=new UserDao();
		List<User> list=userDao.getAllUser();
		boolean value=false;
		
		for(User dbUser:list)
		{
			if(dbUser.getEmail().equals(email))
			{
				value=true;
				break;
			}
		}
		
		if(value)
		{
			//email present in DB >> check the password
			User user=userDao.getUserByEmail(email);
			if(user.getPassword().equals(password))
			{
				//password is same >> login success
				req.setAttribute("user", user);
				RequestDispatcher dispatcher=req.getRequestDispatcher("user_home.jsp");
				dispatcher.forward(req, resp);
			}
			else
			{
				//wrong password >> send a message
				req.setAttribute("message","Invalid password");
				RequestDispatcher dispatcher=req.getRequestDispatcher("user_login.jsp");
				dispatcher.include(req, resp);
			}
		}
		else
		{
			//email NOT present in DB >> send a message
			req.setAttribute("message","Invalid email");
			RequestDispatcher dispatcher=req.getRequestDispatcher("user_login.jsp");
			dispatcher.include(req, resp);
		}
	}
}
