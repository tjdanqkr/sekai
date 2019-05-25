package net.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.OrderListBean;
import net.product.db.OrderListDAO;

public class ModifyOrderListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward;
		
		OrderListDAO dao = new OrderListDAO();
		
		OrderListBean bean = new OrderListBean();
		
		/*
		 * DB result.
		 */
		boolean result = false;
		
		/*
		 * check that requestor is right seller.
		 */
		String id = "";
		
		request.setCharacterEncoding("UTF-8");
		
		id = request.getSession().getAttribute("id")+"";
		
		if(!id.equals(request.getParameter("seller"))) {
			dao.close();
			
			/*
			 * Refuse the request.
			 */
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./");
			
			return forward;
		}
		
		/*
		 * orderId : target
		 * status : new value
		 */
		bean.setOrderId(request.getParameter("orderId"));
		bean.setStatus(request.getParameter("status"));
		
		result = dao.updateOrderListStatus(bean);
		dao.close();
		if(!result) {
			System.err.println("ERROR - Failed update the status of order list");
			return null;
		}
		
		forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("mypage.me");
		
		return forward;
	}

}
