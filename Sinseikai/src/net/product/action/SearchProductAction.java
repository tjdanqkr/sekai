package net.product.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.ProductBean;
import net.product.db.ProductDAO;

public class SearchProductAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductDAO productDAO = null;
		
		List<ProductBean> productBeans = null;
		ProductBean productBean = new ProductBean();
		
		String search = request.getParameter("keyword"); // Get search text.
		
		// Set search keyword to bean.
		try{ // search keyword is number?
			productBean.setProductNumber(Integer.parseInt(search));
		}catch(NumberFormatException nfe) {}
		productBean.setBrandName(search);
		productBean.setModelNumber(search);
		productBean.setModelName(search);
		
		// Set search keyword to bean.
		try{ // search keyword is number?
			productBean.setCategorycode(Integer.parseInt(search));
		}catch(NumberFormatException nfe) {}
		
		productDAO = new ProductDAO();
		productBeans = productDAO.searchAsKeyword(productBean);
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
