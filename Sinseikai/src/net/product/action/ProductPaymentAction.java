package net.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.action.Action;
import net.action.ActionForward;
import net.product.db.OrderListBean;
import net.product.db.OrderListDAO;
import net.product.db.ProductBean;

public class ProductPaymentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrderListDAO dao = new OrderListDAO();
		OrderListBean bean = new OrderListBean();
		boolean result = false;
		int i= (int)(Math.random()*1000000000);
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getParameter("option2"));
		bean.setOrderId(Integer.toString(i));
		bean.setBuyer(request.getSession().getAttribute("id")+"");
		bean.setSeller(request.getParameter("seller"));
		bean.setProductNumber(Integer.parseInt(request.getParameter("productNumber").trim()));
	//	bean.setCoupon(!request.getParameter("coupon").equals("0"));
		bean.setPrice(Integer.parseInt(request.getParameter("no")));
		bean.setOptions(request.getParameter("option1")+","+request.getParameter("option2"));
		bean.setAmount(Integer.parseInt(request.getParameter("su")));
		bean.setStatus("결제대기");
		result = dao.insertOrderList(bean); // Insert to orderList using buyer.
		dao.close();
		if(!result) {
			System.err.println("ERROR - Failed insert to orderlist");
			//return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/product/productPay.jsp");
		return forward;
	}

}
