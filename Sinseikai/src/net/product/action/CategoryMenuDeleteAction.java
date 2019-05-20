package net.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.CodexCategoryBean;
import net.product.db.CodexCategoryDAO;
import net.product.db.MenuBean;
import net.product.db.MenuDAO;

public class CategoryMenuDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MenuDAO menuDAO = new MenuDAO();
		CodexCategoryDAO codexCategoryDAO = null;
		
		MenuBean menuBean = new MenuBean();
		CodexCategoryBean codexCategoryBean = new CodexCategoryBean();
		
		boolean result = false;
		
		request.setCharacterEncoding("UTF-8");
		
		menuBean.setMajorName(request.getParameter("majorName"));
		menuBean.setMinorName(request.getParameter("minorName"));
		menuBean.setCategoryName(request.getParameter("categoryName"));
		
		result = menuDAO.deleteMenu(menuBean);
		menuDAO.close();
		if(!result) {
			System.err.println("ERROR - Failed delete from category menu");
			
			return null;
		}
		
		codexCategoryDAO = new CodexCategoryDAO();
		codexCategoryBean.setCategoryName(categoryName);
	}

}
