package food_order_webapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_order_webapp.dao.UserDao;

@WebServlet("/editprofile")
public class UserEditProfile_Servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		UserDao userDao=new UserDao();
		
		req.setAttribute("user", userDao.getUserById(id));
		RequestDispatcher dispatcher=req.getRequestDispatcher("user_edit_profile.jsp");
		dispatcher.forward(req, resp);
 
	}
}
