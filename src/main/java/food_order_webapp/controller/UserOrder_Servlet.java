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

@WebServlet("/ordernow")
public class UserOrder_Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String umail=req.getParameter("umail");//customer email
		
		UserCartDao userCartDao=new UserCartDao();
		List<UserCart> dbCarts= userCartDao.getAllCartItemsByUserEmail(umail);
		
		UserDao userDao=new UserDao();
		User user=userDao.getUserByEmail(umail);
		
		req.setAttribute("itemlist", dbCarts);
		req.setAttribute("user", user);
		RequestDispatcher dispatcher=req.getRequestDispatcher("user_booking.jsp");
		dispatcher.forward(req, resp);
	}
}
