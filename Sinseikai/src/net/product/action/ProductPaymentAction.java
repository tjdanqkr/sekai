package net.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.OrderListBean;
import net.product.db.OrderListDAO;

public class ProductPaymentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrderListDAO dao = new OrderListDAO();
		
		OrderListBean bean = null;
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/.jsp");
		return forward;
	}

}
