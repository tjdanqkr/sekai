package net.product.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.member.db.MemberBean;
import net.member.db.MemberDAO;
import net.product.db.CodexBrandBean;
import net.product.db.CodexBrandDAO;
import net.product.db.Option1Bean;
import net.product.db.Option1DAO;
import net.product.db.OrderListBean;
import net.product.db.OrderListDAO;
import net.product.db.ProductBean;
import net.product.db.ProductDAO;

	
public class ProductPaymentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrderListDAO dao = new OrderListDAO();
		OrderListBean bean = new OrderListBean();
		boolean result = false;
		HttpSession session = request.getSession();
		ProductDAO productDAO = new ProductDAO();
		Option1DAO option1DAO = null;
		CodexBrandDAO codexBrandDAO = null;
		ProductBean productBean = new ProductBean();
		List<Option1Bean> option1Beans = null;
		CodexBrandBean codexBrandBean = null;
		MemberBean memberBean = new MemberBean();
		MemberDAO memberDAO = new MemberDAO();
		
		bean.setEmail(request.getParameter("email"));
		bean = memberDAO.kensaku(memberBean);
		memberDAO.close();
		if(memberBean == null) {
			System.err.println("ERROR - Failed get the member");
			return null;
		}
		
		
		request.setCharacterEncoding("UTF-8");
		bean.setOrderId("orderId");
		bean.setBuyer(request.getSession().getAttribute("id")+"");
		bean.setSeller(request.getParameter("sellerEmail"));
		bean.setProductNumber(Integer.parseInt(request.getParameter("productNumber").trim()));
	//	bean.setCoupon(!request.getParameter("coupon").equals("0"));
		bean.setPrice(Integer.parseInt(request.getParameter("price")));
		bean.setOptions(request.getParameter("options"));
		bean.setAmount((int) (request.getSession().getAttribute("quantity")));
		System.out.println("시작14");
		bean.setStatus(request.getParameter("status"));
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
