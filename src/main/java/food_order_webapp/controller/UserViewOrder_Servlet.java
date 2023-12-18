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
import food_order_webapp.dao.UserOrderDao;
import food_order_webapp.dto.User;
import food_order_webapp.dto.UserOrder;

@WebServlet("/uservieworder")
public class UserViewOrder_Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int userid=Integer.parseInt(req.getParameter("id"));//user id
		
		UserDao userDao=new UserDao();
		User user=userDao.getUserById(userid);
		
		UserOrderDao userOrderDao=new UserOrderDao();
		List<UserOrder> dbOrders=userOrderDao.getAllOrdersByEmail(user.getEmail());
		
		req.setAttribute("user", user);
		req.setAttribute("orderlist", dbOrders);
		RequestDispatcher dispatcher=req.getRequestDispatcher("user_orders.jsp");
		dispatcher.forward(req, resp);
	}
}
