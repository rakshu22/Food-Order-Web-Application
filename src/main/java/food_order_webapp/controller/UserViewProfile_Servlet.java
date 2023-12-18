package food_order_webapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_order_webapp.dao.UserCartDao;
import food_order_webapp.dao.UserDao;
import food_order_webapp.dto.User;

@WebServlet("/viewprofile")
public class UserViewProfile_Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		UserDao userDao=new UserDao();
		User user=userDao.getUserById(id);
		UserCartDao userCartDao=new UserCartDao();
		
		req.setAttribute("listofitems", userCartDao.getAllCartItemsByUserEmail(user.getEmail()));
		req.setAttribute("user", user);
		RequestDispatcher dispatcher=req.getRequestDispatcher("user_profile.jsp");
		dispatcher.forward(req, resp);
	}
}
