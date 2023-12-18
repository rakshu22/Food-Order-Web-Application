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

@WebServlet("/updateprofile")
public class UserUpdateProfile_Servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long phone=Long.parseLong(req.getParameter("phone"));
		String address=req.getParameter("address");
		
		ServletContext context=getServletContext();
		String termsandpolicy=context.getInitParameter("termsandpolicy");
		
		User user=new User();
		user.setUser_id(id);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		user.setAddress(address);
		user.setTermsandpolicy(termsandpolicy);

		UserDao userDao=new UserDao();
		List<User> list=userDao.getRemainingUser(id);
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
			//email already exists >> send message
			req.setAttribute("message", "Email already exists");
			req.setAttribute("user", userDao.getUserById(id));
			RequestDispatcher dispatcher=req.getRequestDispatcher("user_edit_profile.jsp");
			dispatcher.forward(req, resp);
		}
		else 
		{
			//email not same as other >> update profile
			userDao.updateUser(user);
			
			req.setAttribute("message", "Updated successfully!");
			req.setAttribute("user",userDao.getUserById(id) );
			RequestDispatcher dispatcher=req.getRequestDispatcher("user_profile.jsp");
			dispatcher.forward(req, resp);
		}
	}
	
}
