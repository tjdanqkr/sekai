package net.admin.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.FrontController;
import net.admin.db.PurchaseHistoryBean;
import net.product.action.CategoryMenuAction;
import net.action.Action;
import net.action.ActionForward;

/**
 * Servlet implementation class ProductFrontController
 */
public class AdminFrontController extends HttpServlet implements FrontController {
    
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contentPath = request.getContextPath();
		String command = RequestURI.substring(contentPath.length());
		ActionForward forward = null;
		Action action = null;
		
		
		action = new AdminMenuAction(); // Admin menu is call always. 
		try {
			action.execute(request, response); 
		}catch(Exception e) { 
			e.printStackTrace();
		}
		 
		
		if(command.equals("/admin.ad")) { // Admin main menu.
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/admin/adminContainer.jsp");
		}else if(command.equals("/overview.ad")) {
			action = new OverviewAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/purchaseHistory.ad")) {
			action = new PurchaseHistoryAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/login.ad")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/admin/adminlogin.jsp");
		}else if(command.equals("/loginAction.ad")) {
			action = new LoginAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(forward.isRedirect()) {
			response.sendRedirect(forward.getPath());
		}else {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
}
