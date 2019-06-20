package net.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.MenuBean;
import net.product.db.MenuDAO;

public class CategoryMenuDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MenuDAO menuDAO = new MenuDAO();
		
		MenuBean menuBean = new MenuBean();
		
		boolean result = false;
		
		request.setCharacterEncoding("UTF-8");
		
		menuBean.setCategoryCode(Integer.parseInt(request.getParameter("categoryCode")));
		
		result = menuDAO.deleteMenu(menuBean);
		menuDAO.close();
		if(!result) {
			System.err.println("ERROR - Failed delete from category menu");
			
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./admin/categoryFail.html");
			return forward;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("manage-category.ad");
		return forward;
	}

}
