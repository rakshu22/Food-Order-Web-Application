package food_order_webapp.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_order_webapp.dao.AdminDao;
import food_order_webapp.dto.AdminMenu;

@WebServlet("/getimage")
public class GetImage_Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("image/png");
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			
			AdminDao adminDao=new AdminDao();
			AdminMenu item= adminDao.getItemById(id);
			
			ServletOutputStream sos=resp.getOutputStream();
			sos.write(item.getImage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
