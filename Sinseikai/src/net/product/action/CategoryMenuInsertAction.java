package net.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.CodexCategoryBean;
import net.product.db.CodexCategoryDAO;
import net.product.db.MenuBean;
import net.product.db.MenuDAO;

public class CategoryMenuInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CodexCategoryDAO codexCategoryDAO = new CodexCategoryDAO();
		MenuDAO menuDAO = null;
		
		CodexCategoryBean codexCategoryBean = new CodexCategoryBean();
		MenuBean menuBean = new MenuBean();
		
		boolean result = false;
		
		request.setCharacterEncoding("UTF-8");

		// Insert to codex category.
		codexCategoryBean.setCategoryName(request.getParameter("categoryName"));
		codexCategoryBean.setCategorycode(Integer.parseInt(request.getParameter("categorycode")));
		
		result = codexCategoryDAO.insertCodexCategory(codexCategoryBean);
		codexCategoryDAO.close();
		if(!result) {
			System.err.println("ERROR - Failed insert to codex category");
			
			return null;
		}
		
		// Insert to category menu.
		menuDAO = new MenuDAO();
		menuBean.setMajorName(request.getParameter("majorName"));
		menuBean.setMinorName(request.getParameter("minorName"));
		menuBean.setCategoryName(request.getParameter("categoryName"));
		
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
