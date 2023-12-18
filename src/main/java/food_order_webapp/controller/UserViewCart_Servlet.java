package food_order_webapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_order_webapp.dao.UserCartDao;
import food_order_webapp.dao.UserDao;
import food_order_webapp.dto.User;
import food_order_webapp.dto.UserCart;

@WebServlet("/viewcart")
public class UserViewCart_Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));// user id

		UserDao userDao = new UserDao();
		User user = userDao.getUserById(id);

		UserCartDao usercartDao = new UserCartDao();
		List<UserCart> dbCarts = usercartDao.getAllCartItemsByUserEmail(user.getEmail());

		req.setAttribute("user", user);
		req.setAttribute("itemlist", dbCarts);
		RequestDispatcher dispatcher = req.getRequestDispatcher("user_cart.jsp");
		dispatcher.forward(req, resp);

	}
}
