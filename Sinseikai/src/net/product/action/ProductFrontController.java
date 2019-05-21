package net.product.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.FrontController;

import net.action.Action;
import net.action.ActionForward;

/**
 * Servlet implementation class ProductFrontController
 */
public class ProductFrontController extends HttpServlet implements FrontController {
    
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contentPath = request.getContextPath();
		String command = RequestURI.substring(contentPath.length());
		ActionForward forward = null;
		Action action = null;
		System.out.println("pr시작");
		action = new CategoryMenuAction(); // CategoryMenu is call always.
		try {
			action.execute(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(command.equals("/")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/.jsp");
		}else if(command.equals("/product_into.pr")) { // Main.
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/product/product_into.jsp");
		}else if(command.equals("/searchProduct.pr")) { // Search the product.
			action = new SearchProductAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/display-fo/categoryShop.pr")) { // Show the products correct to category.
			action = new CategoryShopAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/productInto.pr")) { // Show the product.
			action = new GoodsDetailAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/productPay.pr")) {
			action = new ProductPaymentAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/showOrderList.pr")) {
			action = new ShowOrderListAction();
			
			try {
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/manageCategory.pr")) { // Admin menu.
			/*
			 * Manager : category menu.
			 */

			request.setAttribute("centerUri", "/admin/manageCategory.jsp"); // Put the result.
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/admin/adminContainer.jsp");
		}else if(command.equals("/manageCategoryInsert.pr")) { // Insert to category menu.
			action = new CategoryMenuInsertAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/manageCategoryModify.pr")) { // Modify the category menu.
			action = new CategoryMenuModifyAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/manageCategoryDelete.pr")) { // Delete from category menu.
			action = new CategoryMenuDeleteAction();
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
