package food_order_webapp.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_order_webapp.dao.AdminDao;
import food_order_webapp.dto.AdminMenu;

@WebServlet("/viewmenu")
public class AdminViewMenu_Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AdminDao adminDao=new AdminDao();
		List<AdminMenu> dbItems= adminDao.getAllItems();
		
		req.setAttribute("listofitems", dbItems);
		RequestDispatcher dispatcher=req.getRequestDispatcher("admin_menu.jsp");
		dispatcher.forward(req, resp);
		
	}
}
