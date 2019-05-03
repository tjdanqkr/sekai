package net.product.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.CodexCategoryBean;
import net.product.db.CodexCategoryDAO;
import net.product.db.ProductBean;
import net.product.db.ProductDAO;

public class SearchProductAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CodexCategoryDAO codexCategoryDAO = new CodexCategoryDAO();
		ProductDAO productDAO = null;
		
		CodexCategoryBean codexCategoryBean = new CodexCategoryBean();
		List<ProductBean> productBeans = null;
		ProductBean productBean = null;
		
		String search = request.getParameter("search?"); // Get search text.
		
		codexCategoryBean.setCategoryName(search);
		
		
		// Set search keyword to bean.
		try{ // search keyword is number?
			productBean.setProductNumber(Integer.parseInt(search));
		}catch(NumberFormatException nfe) {}
		productBean.setBrandName(search);
		productBean.setModelNumber(search);
		productBean.setModelName(search);
		
		codexCategoryBean = codexCategoryDAO.getCategorycode(codexCategoryBean);
		codexCategoryDAO.close();
		if(codexCategoryBean == null) {
			System.err.println("ERROR - Failed get the categoryCode");
			return null;
		}
		productBean.setCategorycode(codexCategoryBean.getCategorycode());
		
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
		forward.setPath("."); // set at after.
		return forward;
	}

}
