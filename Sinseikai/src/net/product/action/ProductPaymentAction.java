package net.product.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.action.Action;
import net.action.ActionForward;
import net.admin.db.PurchaseHistoryBean;
import net.admin.db.PurchaseHistoryDAO;
import net.product.db.OrderListBean;
import net.product.db.OrderListDAO;
import net.product.db.ProductBean;

public class ProductPaymentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrderListDAO orderListDAO = new OrderListDAO();
		PurchaseHistoryDAO purchaseHistoryDAO = null;
		
		OrderListBean orderListBean = new OrderListBean();
		PurchaseHistoryBean purchaseHistoryBean = new PurchaseHistoryBean();
		
		/*
		 * Used to set the purchaseHistory bean.
		 */
		ProductBean productBean = null;
		
		boolean result = false;
		
		/*
		 * Used to set the orderId. 
		 */
		int i = (int)(Math.random()*1000000000);
		
		request.setCharacterEncoding("UTF-8");
		
		orderListBean.setOrderId(Integer.toString(i));
		orderListBean.setBuyer(request.getSession().getAttribute("id")+"");
		orderListBean.setSeller(request.getParameter("seller"));
		orderListBean.setProductNumber(Integer.parseInt(request.getParameter("productNumber").trim()));
		orderListBean.setCoupon(request.getParameter("coupon"));
		orderListBean.setPrice(Integer.parseInt(request.getParameter("no")));
		orderListBean.setOptions(request.getParameter("options"));
		orderListBean.setAmount(Integer.parseInt(request.getParameter("su")));
		orderListBean.setStatus("결제대기");
		
		result = orderListDAO.insertOrderList(orderListBean); // Insert to orderList using buyer.
		orderListDAO.close();
		if(!result) {
			System.err.println("ERROR - Failed insert to orderlist");
			return null;
		}
		
		/*
		 * Insert the purchase history.
		 */
		purchaseHistoryDAO = new PurchaseHistoryDAO();
		
		productBean = (ProductBean)request.getSession().getAttribute("productBean");
		
		purchaseHistoryBean.setProductNumber(productBean.getProductNumber());
		purchaseHistoryBean.setBrandName(productBean.getBrandName());
		purchaseHistoryBean.setModelNumber(productBean.getModelNumber());
		purchaseHistoryBean.setModelName(productBean.getModelName());
		purchaseHistoryBean.setCoupon(productBean.getCoupon());
		purchaseHistoryBean.setFullPrice(orderListBean.getPrice() * orderListBean.getAmount());
		purchaseHistoryBean.setDiscountRate(productBean.getDiscountRate());
		purchaseHistoryBean.setRating(productBean.getRating());
		purchaseHistoryBean.setDeliveryPeriod(productBean.getDeliveryPeriod());
		purchaseHistoryBean.setCategoryCode(productBean.getCategorycode());
		purchaseHistoryBean.setPurchaseDate(new Date(System.currentTimeMillis()));
		
		purchaseHistoryDAO.insertHistory(purchaseHistoryBean);
		purchaseHistoryDAO.close();
		if(!result) {
			System.err.println("ERROR - Failed insert to purchaseHistory");
			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("product-into.pr");
		return forward;
	}

}
