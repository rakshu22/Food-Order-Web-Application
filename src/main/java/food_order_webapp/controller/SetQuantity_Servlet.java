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

@WebServlet("/setquantity")
public class SetQuantity_Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action=req.getParameter("action");
		int cartid=Integer.parseInt(req.getParameter("id"));//cart id
		String umail=req.getParameter("umail"); //cust email
		
		UserCartDao userCartDao=new UserCartDao();
		List<UserCart> dbCarts= userCartDao.getAllCartItemsByUserEmail(umail);
		
		if(action.equals("inc"))
		{
			for(UserCart cart: dbCarts)
			{
				if(cart.getCart_id()==cartid)
				{
					int quantity=cart.getFquantity();
					quantity=quantity+1;
					userCartDao.incQuantity(quantity,cartid);
					break;
				}
			}
		}
		
		if(action.equals("dec"))
		{
			for(UserCart cart: dbCarts)
			{
				if(cart.getCart_id()==cartid)
				{
					int quantity=cart.getFquantity();
					quantity=quantity-1;
					userCartDao.decQuantity(quantity,cartid);
					break;
				}
			}
		}
		
		UserDao userDao=new UserDao();
		
		req.setAttribute("user", userDao.getUserByEmail(umail));
		req.setAttribute("itemlist", userCartDao.getAllCartItemsByUserEmail(umail));
		RequestDispatcher dispatcher=req.getRequestDispatcher("user_cart.jsp");
		dispatcher.forward(req, resp);
	}
}
