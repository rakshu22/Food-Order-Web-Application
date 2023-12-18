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

@WebServlet("/editstatus")
public class AdminEditStatus_Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int order_id=Integer.parseInt(req.getParameter("orderid"));
		
		UserOrderDao userOrderDao=new UserOrderDao();
		List<UserOrder> dbOrder=userOrderDao.getOrdersById(order_id);
		
		req.setAttribute("orderlist", dbOrder);
		RequestDispatcher dispatcher=req.getRequestDispatcher("admin_edit_order.jsp");
		dispatcher.forward(req, resp);
	}
}
