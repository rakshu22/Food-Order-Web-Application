package food_order_webapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_order_webapp.dao.UserOrderDao;
import food_order_webapp.dto.UserOrder;

@WebServlet("/vieworder")
public class AdminViewOrders_Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserOrderDao userOrderDao=new UserOrderDao();
		List<UserOrder> userOrders= userOrderDao.getAllOrders();
		
		req.setAttribute("user orders", userOrders);
		RequestDispatcher dispatcher=req.getRequestDispatcher("admin_orders.jsp");
		dispatcher.forward(req, resp);
	}
}
