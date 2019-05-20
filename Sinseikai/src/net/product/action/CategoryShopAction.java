package net.product.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.MenuBean;
import net.product.db.ProductBean;
import net.product.db.ProductDAO;

public class CategoryShopAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductDAO productDAO = null;
		
		MenuBean menuBean = new MenuBean();
		List<ProductBean> productBeans = null;
		
		menuBean.setCategoryCode(Integer.parseInt(request.getParameter("categoryCode")));
		
		productDAO = new ProductDAO();
		productBeans = productDAO.getProductsAsCategorycode(menuBean); // Find Products as categoryCode.
		productDAO.close();
		if(productBeans == null) {
			System.err.println("ERROR - Failed get the products");
			return null;
		}
		
		request.setAttribute("productBeans", productBeans); // Put the result.
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/.jsp");
		return forward;
	}

}
