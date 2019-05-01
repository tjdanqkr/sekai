package net.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.ProductBean;
import net.product.db.ProductDAO;

public class GoodsDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductDAO dao = new ProductDAO();
		ProductBean bean = new ProductBean();
		bean.setProductNumber(Integer.parseInt(request.getParameter("productNumber")));
		
		bean = dao.getProduct(bean);
		dao.close();
		if(bean != null) {
			request.setAttribute("productBean", bean);
			
			// you should coding dao option and codexbrand.
			
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
//			forward.setPath(address); // set at after.
			return forward;
		}
		
		return null;
	}

}
