package net.product.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.FrontController;
import net.admin.action.PurchaseHistoryAction;
import net.admin.db.PurchaseHistoryBean;
import net.product.util.PurchaseHistoryUtility;
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
			action =new RegistProductAction();
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
		}else if(command.equals("/modify-order-list.pr")) {
			/*
			 * Mypage : Modify order list of user.
			 */
			action = new ModifyOrderListAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/admin-get-overview.pr")) {
			/*
			 * Manager : get overview data.
			 */
			PurchaseHistoryUtility purchaseHistoryUtility = new PurchaseHistoryUtility();
			
			List<PurchaseHistoryBean> beans = null;
			
			Map<String, Map<String, Integer>> brandNameMaps = null;
			
			action = new PurchaseHistoryAction();
			try {
				forward = action.execute(request, response);
				
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
				request.getSession().setAttribute("brandNameMaps", brandNameMaps);
				
				forward.setRedirect(true);
				
				/*
				 * End of data collect.
				 * back to the ~.ad
				 */
				forward.setPath("admin-overview-show.ad");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/manage-category.pr")) {
			/*
			 * Manager : category menu.
			 */
			request.setAttribute("centerUri", "/admin/manageCategory.jsp");
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/admin/adminContainer.jsp");
		}else if(command.equals("/manage-category-insert.pr")) {
			/*
			 * Manager : category insert.
			 */
			action = new CategoryMenuInsertAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/manage-category-modify.pr")) {
			/*
			 * Manager : category modify.
			 */
			action = new CategoryMenuModifyAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/manage-category-delete.pr")) {
			/*
			 * Manager : category delete.
			 */
			action = new CategoryMenuDeleteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/purchase-history.pr")) {
			/*
			 * Manager : purchase history.
			 */
			action = new PurchaseHistoryAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/lookup-product.pr")) {
			/*
			 * Manager : lookup product.
			 */
			request.setAttribute("centerUri", "/admin/lookupProduct.jsp");
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/admin/adminContainer.jsp");
		}else if(command.equals("/lookup-product-search.pr")) {
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
				forward.setPath("/admin/adminContainer.jsp");
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
