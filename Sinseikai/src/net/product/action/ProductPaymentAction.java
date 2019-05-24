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
		OrderListBean bean = new OrderListBean();
		boolean result = false;
		System.out.println(request.getSession().getAttribute("id")+"");
		
		
		
		request.setCharacterEncoding("UTF-8");
		bean.setOrderId("orderId");
		bean.setBuyer(request.getSession().getAttribute("id")+"");
		bean.setSeller(request.getParameter("sellerEmail"));
		bean.setProductNumber(Integer.parseInt(request.getParameter("productNumber").trim()));
	//	bean.setCoupon(!request.getParameter("coupon").equals("0"));
		bean.setPrice(Integer.parseInt(request.getParameter("no")));
		bean.setOptions(request.getParameter("options"));
		bean.setAmount(Integer.parseInt(request.getParameter("su")));
		System.out.println("시작14");
		bean.setStatus("결제대기");
		System.out.println("시작15");
		result = dao.insertOrderList(bean); // Insert to orderList using buyer.
		dao.close();
		if(!result) {
			System.err.println("ERROR - Failed insert to orderlist");
			//return null;
		}
		
		ActionForward forward = new ActionForward();
		System.out.println("dd");
		forward.setRedirect(false);
		forward.setPath("/product/productPay.jsp");
		return forward;
	}

}
