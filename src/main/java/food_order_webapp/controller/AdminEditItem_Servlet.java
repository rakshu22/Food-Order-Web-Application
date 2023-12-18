package food_order_webapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_order_webapp.dao.AdminDao;
import food_order_webapp.dto.AdminMenu;

@WebServlet("/edititem")
public class AdminEditItem_Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		AdminDao adminDao=new AdminDao();
		AdminMenu dbItem= adminDao.getItemById(id);
		
		req.setAttribute("item", dbItem);
		RequestDispatcher dispatcher=req.getRequestDispatcher("admin_edit_item.jsp");
		dispatcher.forward(req, resp);
	}
}
