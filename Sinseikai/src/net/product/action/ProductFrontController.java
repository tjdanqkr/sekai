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
		
		if(command.equals("/product-into.pr")) { // Main.
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/product/product_into.jsp");
			
		}else if(command.equals("/product-input.pr")) { 
			action =new BrandgetAction();
			try {
				forward = action .execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}					
		}else if(command.equals("/regist-product.pr")) {//상품등록할거야
			action =new RegistProductAction();
			try {
				forward = action .execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}			
		}else if(command.equals("/search-product.pr")) { // Search the product.
			action = new SearchProductAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/category-product.pr")) { // Show the products correct to category.
			action = new CategoryShopAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/productinto.pr")) { // Show the product.
			action = new GoodsDetailAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/product-pay.pr")) {
			action = new ProductPaymentAction();
			
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
