package food_order_webapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_order_webapp.dao.UserDao;
import food_order_webapp.dto.User;

@WebServlet("/signup")
public class UserSignup_Servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long phone=Long.parseLong(req.getParameter("phone"));
		String address=req.getParameter("address");
		
		ServletContext context=getServletContext();
		String termsandpolicy=context.getInitParameter("termsandpolicy");
		
		User user=new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		user.setAddress(address);
		user.setTermsandpolicy(termsandpolicy);
		
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
			//email already present
			req.setAttribute("message", "Email already exists");
			RequestDispatcher dispatcher=req.getRequestDispatcher("user_signup.jsp");
			dispatcher.include(req, resp);
		}
		else {
			//email not present
			//user should be allowed to User
			userDao.saveUser(user);
			
			req.setAttribute("message", "Signed up successfully");
			RequestDispatcher dispatcher=req.getRequestDispatcher("user_login.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
}
