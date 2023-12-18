package food_order_webapp.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import food_order_webapp.dao.AdminDao;
import food_order_webapp.dto.AdminMenu;

@WebServlet("/updateitem")
@MultipartConfig(maxFileSize = 169999999)
public class AdminUpdateItem_Servlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id= Integer.parseInt(req.getParameter("id"));
		Part part=req.getPart("image");
		String name= req.getParameter("name");
		float price=Float.parseFloat(req.getParameter("price"));
		
		InputStream is=part.getInputStream();
			byte[] data = new byte[is.available()];
			is.read(data);
		
		AdminMenu adminMenu=new AdminMenu();
		adminMenu.setItem_id(id);
		adminMenu.setImage(data);
		adminMenu.setName(name);
		adminMenu.setPrice(price);
		
		AdminDao adminDao=new AdminDao();
		adminDao.updateItem(adminMenu);
		
		req.setAttribute("message", name+" updated successfully");
		req.setAttribute("listofitems", adminDao.getAllItems());
		RequestDispatcher dispatcher=req.getRequestDispatcher("admin_menu.jsp");
		dispatcher.forward(req, resp);
		
	}
}
