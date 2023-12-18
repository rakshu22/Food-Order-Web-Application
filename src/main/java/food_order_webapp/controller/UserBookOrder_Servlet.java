package food_order_webapp.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_order_webapp.dao.UserCartDao;
import food_order_webapp.dao.UserDao;
import food_order_webapp.dao.UserOrderDao;
import food_order_webapp.dto.User;
import food_order_webapp.dto.UserCart;
import food_order_webapp.dto.UserOrder;
import food_order_webapp.dto.UserOrderItems;

@WebServlet("/bookorder")
public class UserBookOrder_Servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String umail = req.getParameter("umail");
		String address = req.getParameter("address");
		long phone = Long.parseLong(req.getParameter("phone"));
		float total = Float.parseFloat(req.getParameter("total"));
		String payment_mode = req.getParameter("pay_mode");

		UserDao userDao = new UserDao();
		User user = userDao.getUserByEmail(umail);

		UserCartDao userCartDao = new UserCartDao();
		List<UserCart> dbCarts = userCartDao.getAllCartItemsByUserEmail(umail);

		UserOrderDao userOrderDao=new UserOrderDao();
		
		LocalDateTime date = LocalDateTime.now();  
	    DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("MMMddyyHHmm");  
	    String dbDate = date.format(dateformat);
	    String order_ref= dbDate+"UID"+user.getUser_id();
//		save order items
				
				
				for(UserCart cart:dbCarts)
				{
					UserOrderItems uItems=new UserOrderItems();
					uItems.setUmail(umail);
					uItems.setFid(cart.getFid());
					uItems.setFimage(cart.getFimage());
					uItems.setFname(cart.getFname());
					uItems.setFprice(cart.getFprice());
					uItems.setFquantity(cart.getFquantity());
					uItems.setSubtotal(cart.getFprice() * cart.getFquantity());
					uItems.setOrder_ref(order_ref);
					
					//save ordered item
					UserOrderItems dbItems= userOrderDao.saveOrderItems(uItems);
					if(dbItems!=null)
					{
						userCartDao.deleteItemFromCart(cart.getCart_id());
					}
				}
				
		//save order details
		UserOrder userOrder=new UserOrder();
		userOrder.setDatetime(LocalDateTime.now());
		userOrder.setUname(user.getName());
		userOrder.setUaddress(address);
		userOrder.setUphone(phone);
		userOrder.setUmail(umail);
		userOrder.setTotalbill(total);
		userOrder.setPayment_mode(payment_mode);
		userOrder.setPayment_status(null);
		userOrder.setOrder_status("Order placed");
		
		List<UserOrderItems> uList=userOrderDao.getAllOrderItemsByEmail(umail,order_ref);
		userOrder.setUserOrderItems(uList);
		//save order
		UserOrder uOrder= userOrderDao.saveOrder(userOrder);
		
		req.setAttribute("message", "Your order was successful");
		req.setAttribute("user", user);
		RequestDispatcher dispatcher = req.getRequestDispatcher("user_order_success.jsp");
		dispatcher.forward(req, resp);
	
	}
}
