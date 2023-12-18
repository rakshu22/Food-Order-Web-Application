package food_order_webapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_order_webapp.dao.FeedbackDao;
import food_order_webapp.dto.Feedback;

@WebServlet("/viewfeed")
public class AdminViewFeedback_Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FeedbackDao feedbackDao=new FeedbackDao();
		List<Feedback> feedbacks= feedbackDao.getAllFeedbacks();
		
		req.setAttribute("feedbacks",feedbacks );
		RequestDispatcher dispatcher=req.getRequestDispatcher("admin_feed.jsp");
		dispatcher.forward(req, resp);
	}
}
