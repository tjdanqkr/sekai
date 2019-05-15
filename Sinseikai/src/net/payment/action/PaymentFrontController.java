package net.payment.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.FrontController;
import net.product.action.CategoryMenuAction;
import net.product.action.SearchProductAction;
import net.action.Action;
import net.action.ActionForward;
public class PaymentFrontController extends HttpServlet implements FrontController{
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contentPath = request.getContextPath();
		String command = RequestURI.substring(contentPath.length());
		ActionForward forward = null;
		Action action = null;
		try {
			action.execute(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(command.equals("/")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/payment/productPay.jsp");
		}else if(command.equals("/productPay.py")) { // Search the product.
			action = new SearchProductAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
