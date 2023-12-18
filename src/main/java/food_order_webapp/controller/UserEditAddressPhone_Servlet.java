package food_order_webapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_order_webapp.dao.UserDao;

@WebServlet("/editaddress&phone")
public class UserEditAddressPhone_Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int userid=Integer.parseInt(req.getParameter("userid"));
		
		UserDao userDao=new UserDao();
		
		req.setAttribute("user", userDao.getUserById(userid));
		RequestDispatcher dispatcher=req.getRequestDispatcher("user_edit_addph.jsp");
		dispatcher.forward(req, resp);
	}
}
