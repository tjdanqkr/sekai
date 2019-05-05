package net.product.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.MenuBean;
import net.product.db.MenuDAO;

public class CategoryMenuAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MenuDAO dao = new MenuDAO();
		List<MenuBean> beans = dao.getMenu();
		dao.close();
		System.out.println("gd");
		if(beans == null) {
			System.err.println("ERROR - Failed get the category menu");
			return null;
		}		
		request.setAttribute("menuBeans", beans); // Put the result.
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/product_into.jsp");
		return forward;
	}

}
