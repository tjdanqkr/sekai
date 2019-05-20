package net.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.MenuBean;
import net.product.db.MenuDAO;

public class CategoryMenuInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MenuDAO menuDAO = new MenuDAO();
		
		MenuBean menuBean = new MenuBean();
		
		boolean result = false;
		
		request.setCharacterEncoding("UTF-8");
		
		// Insert to category menu.
		menuDAO = new MenuDAO();
		menuBean.setMajorName(request.getParameter("majorName"));
		menuBean.setMinorName(request.getParameter("minorName"));
		menuBean.setCategoryName(request.getParameter("categoryName"));
		menuBean.setCategoryCode(Integer.parseInt(request.getParameter("categoryCode")));
		
		result = menuDAO.insertMenu(menuBean);
		menuDAO.close();
		if(!result) {
			System.err.println("ERROR - Failed insert to category menu");
			
			return null;
		}

		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("manageCategory.pr");
		return forward;
	}

}
