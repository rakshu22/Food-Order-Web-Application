package food_order_webapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_order_webapp.dao.FeedbackDao;
import food_order_webapp.dto.Feedback;

@WebServlet("/feedback")
public class UserFeedback_Servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		long phone=Long.parseLong(req.getParameter("phone"));
		String feedback=req.getParameter("feedback");
		
		Feedback feed=new Feedback();
		feed.setName(name);
		feed.setEmail(email);
		feed.setPhone(phone);
		feed.setFeedback(feedback);
		
		FeedbackDao feedbackdao=new FeedbackDao();
		Feedback dbFeedback= feedbackdao.saveFeedback(feed);
		
		if(dbFeedback!=null)
		{
			req.setAttribute("message", "Feedback submitted successfully");
			RequestDispatcher dispatcher=req.getRequestDispatcher("feedback.jsp");
			dispatcher.include(req, resp);
		}
	}

}
