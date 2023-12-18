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
import food_order_webapp.dto.UserCart;

@WebServlet("/deletefromcart")
public class UserDeleteFromCart_Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cartid=Integer.parseInt(req.getParameter("id"));//cart id
		int userid=Integer.parseInt(req.getParameter("uid"));//user id
		
		UserDao userDao=new UserDao();
		
		UserCartDao userCartDao=new UserCartDao();
		UserCart userCart= userCartDao.deleteItemFromCart(cartid);
		 
		UserCartDao usercartDao=new UserCartDao();
		List<UserCart> dbCarts=usercartDao.getAllCartItemsByUserEmail(userCart.getUmail());
		
		req.setAttribute("user", userDao.getUserById(userid));
		req.setAttribute("message", userCart.getFname()+"  deleted successfully");
		req.setAttribute("itemlist", dbCarts);
		RequestDispatcher dispatcher=req.getRequestDispatcher("user_cart.jsp");
		dispatcher.forward(req, resp);
	}
}
