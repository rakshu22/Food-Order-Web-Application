package food_order_webapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_order_webapp.dao.AdminDao;
import food_order_webapp.dao.UserCartDao;
import food_order_webapp.dao.UserDao;
import food_order_webapp.dto.AdminMenu;
import food_order_webapp.dto.User;
import food_order_webapp.dto.UserCart;

@WebServlet("/addtocart")
public class UserAddToCart_Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));//item id
		int uid=Integer.parseInt(req.getParameter("uid"));//user id
		
		
		AdminDao adminDao=new AdminDao();
		AdminMenu item= adminDao.getItemById(id);
		
		UserDao userDao=new UserDao();
		User user= userDao.getUserById(uid);
		
		UserCart userCart=new UserCart();
		userCart.setUid(uid);
		userCart.setUmail(user.getEmail());
		userCart.setFid(item.getItem_id());
		userCart.setFimage(item.getImage());
		userCart.setFname(item.getName());
		userCart.setFprice(item.getPrice());
		userCart.setFquantity(1);
		
		
		UserCartDao usercartDao=new UserCartDao();
		UserCart dbUserCart= usercartDao.saveItemToCart(userCart);
		
		List<UserCart> dbCarts=usercartDao.getAllCartItemsByUserEmail(user.getEmail());
		
		if(dbUserCart!=null)
		{
			req.setAttribute("user", user);
			req.setAttribute("message", item.getName()+" added to your cart");
			req.setAttribute("itemlist", dbCarts);
			RequestDispatcher dispatcher=req.getRequestDispatcher("user_cart.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
}
