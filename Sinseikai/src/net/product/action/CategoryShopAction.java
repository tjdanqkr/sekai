package net.product.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.product.Menu;
import net.product.db.ProductBean;
import net.product.db.ProductDAO;

public class CategoryShopAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductDAO dao = new ProductDAO();
		List<ProductBean> beans = null;
		Menu bean = new Menu();
		bean.setCategoryName(request.getParameter("categoryName"));
		
		beans = dao.getCategoryShop(bean);
		dao.close();
		if(beans != null) {
			request.setAttribute("productBeans", beans);
			
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
//			forward.setPath(어딘가의 경로다); // 수정 예정.
			return forward;
		}
		
		return null;
	}

}
