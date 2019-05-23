package net.product.action;

import java.util.List;

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
		OrderListDAO dao = new OrderListDAO();
		
		MemberBean memberBean = new MemberBean();
		List<OrderListBean> buyerOrderListBeans = null;
		List<OrderListBean> sellerOrderListBeans = null;
		
		/*
		 * Set the email as that email in session.
		 * attribute name is 'id'. 
		 */
		memberBean.setEmail(request.getSession().getAttribute("id")+""); 
		
		buyerOrderListBeans = dao.getOrderListForBuyer(memberBean);
		sellerOrderListBeans = dao.getOrderListForSeller(memberBean);
		dao.close();
		if(buyerOrderListBeans == null) {
			System.err.println("ERROR - Failed get the order list for buyer");
			return null;
		}
		if(sellerOrderListBeans == null) {
			System.err.println("ERROR - Failed get the order list for seller");
			return null;
		}

		request.getSession().setAttribute("buyerOrderListBeans", buyerOrderListBeans);
		request.getSession().setAttribute("sellerOrderListBeans", sellerOrderListBeans);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("mypage-show.me");
		
		return forward;
	}

}
