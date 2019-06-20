package net.admin.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.FrontController;
import net.admin.db.PurchaseHistoryBean;
import net.product.action.CategoryMenuAction;
import net.product.action.CategoryMenuDeleteAction;
import net.product.action.CategoryMenuInsertAction;
import net.product.action.CategoryMenuModifyAction;
import net.product.action.SearchProductAction;
import net.product.util.PurchaseHistoryUtility;
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
		 
		
		if(command.equals("/admin.ad")) {
			/*
			 * Admin page and Overview page.
			 * request overview.
			 */
			
			/*
			 * Manager : get overview data.
			 */
			PurchaseHistoryUtility purchaseHistoryUtility = new PurchaseHistoryUtility();
			List<PurchaseHistoryBean> beans = null;
			Map<String, Map<String, Integer>> brandNameMaps = null;
			
			action = new PurchaseHistoryAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			/*
			 * For counting.
			 */
			beans = (List<PurchaseHistoryBean>)request.getAttribute("purchaseHistoryBeans");
			
			/*
			 * Counting.
			 */
			brandNameMaps = purchaseHistoryUtility.counting(beans, "brandName");
			
			/*
			 * Put data to session.
			 */
			request.setAttribute("brandNameMaps", brandNameMaps);
			
			/*
			 * Done get the data.
			 * 
			 * show overview page.
			 */
			request.setAttribute("centerUri", "/admin/overview.jsp");
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/admin/adminContainer.jsp");
		}else if(command.equals("/manage-category.ad")) {
			/*
			 * Manager : category menu.
			 */
			action = new CategoryMenuAction();
			try {
				/*
				 * CategoryMenuAction.execute() is not return ActionForward.
				 * Because this Action is originally used on ProductController.
				 */
				action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			request.setAttribute("centerUri", "/admin/manageCategory.jsp");
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/admin/adminContainer.jsp");
		}else if(command.equals("/manage-category-insert.ad")) {
			/*
			 * Manager : category insert.
			 */
			action = new CategoryMenuInsertAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/manage-category-modify.ad")) {
			/*
			 * Manager : category modify.
			 */
			action = new CategoryMenuModifyAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/manage-category-delete.ad")) {
			/*
			 * Manager : category delete.
			 */
			action = new CategoryMenuDeleteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/purchase-history.ad")) {
			/*
			 * Manager : purchase history.
			 */
			action = new PurchaseHistoryAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/lookup-product.ad")) {
			/*
			 * Manager : lookup product.
			 */
			request.setAttribute("centerUri", "/admin/lookupProduct.jsp");
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/admin/adminContainer.jsp");
		}else if(command.equals("/lookup-product-search.ad")) {
			/*
			 * Manager : search product.
			 */
			action = new SearchProductAction();
			try {
				forward = action.execute(request, response);
				
				request.setAttribute("centerUri", "/admin/lookupProductView.jsp");
				
				/*
				 * SearchProductAction is for non-manager mode.
				 * so set path after execute for manager.
				 */
				forward.setRedirect(false);
				forward.setPath("/admin/adminContainer.jsp");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/login.ad")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/admin/adminlogin.jsp");
		}else if(command.equals("/login-action.ad")) {
			action = new LoginAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/member-lookup.ad")) {
			action = new Member_Lookup();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/member-question.ad")) {
			action = new Member_Question();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/member-qan-reple.ad")) {
			action = new Member_Question_Detail();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/member_reple_update.ad")) {
			action = new Member_Reple_Update();
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
