package net.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.action.Action;
import net.action.ActionForward;


public class ProductPaymentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*OrderListDAO dao = new OrderListDAO();
		System.out.println("시작");
		OrderListBean bean = new OrderListBean();
		
		boolean result = false;
		
		request.setCharacterEncoding("UTF-8");
		System.out.println("앞");
		bean.setOrderId(request.getParameter("orderId"));
		bean.setBuyer(request.getParameter("buyer"));
		bean.setSeller(request.getParameter("seller"));
		bean.setProductNumber(Integer.parseInt(request.getParameter("productNumber")));
		bean.setCoupon(!request.getParameter("coupon").equals("0"));
		bean.setPrice(Integer.parseInt(request.getParameter("price")));
		bean.setOption(request.getParameter("option"));
		bean.setAmount(Integer.parseInt(request.getParameter("amount")));
		bean.setStatus(request.getParameter("status"));
		System.out.println("da");
		result = dao.insertOrderList(bean); // Insert to orderList using buyer.
		dao.close();
		if(!result) {
			System.err.println("ERROR - Failed insert to orderlist");
			//return null;
		}*/
		
		ActionForward forward = new ActionForward();
		System.out.println("dd");
		forward.setRedirect(false);
		forward.setPath("/product/productPay.jsp");
		return forward;
	}

}
