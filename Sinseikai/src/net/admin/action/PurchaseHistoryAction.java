package net.admin.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.admin.db.PurchaseHistoryBean;
import net.admin.db.PurchaseHistoryDAO;

public class PurchaseHistoryAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PurchaseHistoryDAO dao = new PurchaseHistoryDAO();
		
		List<PurchaseHistoryBean> beans = null;
		
		beans = dao.getHistory(); // Get purchase history.
		dao.close();
		if(beans == null) {
			System.err.println("ERROR - Failed get the purchase history");
			return null;
		}

		request.setAttribute("centerUri", "/admin/purchaseHistory.jsp");
		request.setAttribute("purchaseHistoryBeans", beans); // Put the result.
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/admin/adminContainer.jsp");
		return forward;
	}

}
