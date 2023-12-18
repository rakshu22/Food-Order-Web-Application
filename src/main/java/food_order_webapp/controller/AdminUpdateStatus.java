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

@WebServlet("/updatestatus")
public class AdminUpdateStatus extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int order_id=Integer.parseInt(req.getParameter("order_id"));
		String payment_status=req.getParameter("pay_status");
		String order_status=req.getParameter("order_status");
		
		UserOrderDao userOrderDao=new UserOrderDao();
		userOrderDao.updateOrderStatus(order_id,payment_status,order_status);
		
        List<UserOrder> userOrders= userOrderDao.getAllOrders();
		
        req.setAttribute("message", "order #"+order_id+" status updated");
		req.setAttribute("user orders", userOrders);
		RequestDispatcher dispatcher=req.getRequestDispatcher("admin_orders.jsp");
		dispatcher.forward(req, resp);
	}
}
