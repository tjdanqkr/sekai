package net.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.member.db.MemberBean;
import net.product.db.OrderListBean;
import net.product.db.OrderListDAO;

public class ShowOrderListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrderListDAO orderListDAO = new OrderListDAO();
		
		MemberBean memberBean = new MemberBean();
		OrderListBean orderListBean = null;
		
		memberBean.setEmail(request.getSession().getAttribute("email")+""); // Set the email as that email in session. 
		
		
		orderListDAO.getOrderListForBuyer(memberBean);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/.jsp");
		return forward;
	}

}
