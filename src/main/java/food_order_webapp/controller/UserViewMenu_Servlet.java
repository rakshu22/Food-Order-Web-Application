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
import food_order_webapp.dto.AdminMenu;

@WebServlet("/usermenu")
public class UserViewMenu_Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id=Integer.parseInt(req.getParameter("id"));
		
		AdminDao adminDao=new AdminDao();
		List<AdminMenu> dbItems= adminDao.getAllItems();
		
		req.setAttribute("listofitems", dbItems);
		req.setAttribute("userid", id);
		RequestDispatcher dispatcher=req.getRequestDispatcher("user_menu.jsp");
		dispatcher.forward(req, resp);
	}
}
