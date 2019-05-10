package net.product.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.CodexCategoryBean;
import net.product.db.CodexCategoryDAO;

public class ManageCategory implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CodexCategoryDAO dao = new CodexCategoryDAO();
		
		List<CodexCategoryBean> beans = null;
		
		beans = dao.getCategoryCodes();
		if(beans == null) {
			System.err.println("ERROR - Failed get the categoryCodes");
			return null;
		}
		
		request.setAttribute("categoryCodeBeans", beans);
		request.setAttribute("centerUri", "/admin/manageCategory.jsp"); // Put the result.
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/admin/adminContainer.jsp");
		
		return forward;
	}

}
