package net.product.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.member.db.MemberBean;
import net.product.db.Option1Bean;
import net.product.db.Option1DAO;
import net.product.db.OrderListBean;
import net.product.db.OrderListDAO;
import net.product.db.ProductBean;
import net.product.db.ProductDAO;
import net.product.util.Option1Utility;

public class ShowOrderListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrderListDAO orderListDAO = new OrderListDAO();
		ProductDAO productDAO = null;
		Option1DAO option1DAO = null;
		
		MemberBean memberBean = new MemberBean();
		List<OrderListBean> buyerOrderListBeans = null;
		List<ProductBean> buyerProductBeans = new ArrayList<ProductBean>();
		List<List<Option1Bean>> buyerOption1Beans = new ArrayList<List<Option1Bean>>();

		List<OrderListBean> sellerOrderListBeans = null;
		List<ProductBean> sellerProductBeans = new ArrayList<ProductBean>();
		List<List<Option1Bean>> sellerOption1Beans = new ArrayList<List<Option1Bean>>();
		
		/*
		 * Set the email as that email in session.
		 * attribute name is 'id'. 
		 */
		memberBean.setEmail(request.getSession().getAttribute("id")+""); 
		
		buyerOrderListBeans = orderListDAO.getOrderListForBuyer(memberBean);
		sellerOrderListBeans = orderListDAO.getOrderListForSeller(memberBean);
		orderListDAO.close();
		if(buyerOrderListBeans == null) {
			System.err.println("ERROR - Failed get the order list for buyer");
			return null;
		}
		if(sellerOrderListBeans == null) {
			System.err.println("ERROR - Failed get the order list for seller");
			return null;
		}
		
		/*
		 * Get products.
		 */
		productDAO = new ProductDAO();
		for(OrderListBean orderListBean : buyerOrderListBeans) {
			/*
			 * Search product as product number of order list. 
			 */
			
			ProductBean productBean = new ProductBean();
			productBean.setProductNumber(orderListBean.getProductNumber());
			
			productBean = productDAO.getProductAsProductnumber(productBean);
			if(productBean != null) {
				buyerProductBeans.add(productBean);
			}
		}
		
		for(OrderListBean orderListBean : sellerOrderListBeans) {
			/*
			 * Search product as product number of order list. 
			 */
			
			ProductBean productBean = new ProductBean();
			productBean.setProductNumber(orderListBean.getProductNumber());
			
			productBean = productDAO.getProductAsProductnumber(productBean);
			if(productBean != null) {
				sellerProductBeans.add(productBean);
			}
		}
		
		productDAO.close();
		if(buyerOrderListBeans.size() != buyerProductBeans.size()) {
			System.err.println("ERROR - Failed get the product list using buyer order list");
			return null;
		}
		if(sellerOrderListBeans.size() != sellerProductBeans.size()) {
			System.err.println("ERROR - Failed get the product list using seller order list");
			return null;
		}
		
		/*
		 * Get buyer options.
		 */
		option1DAO = new Option1DAO();
		for(int i = 0; i < buyerProductBeans.size(); i++) {
			/*
			 * Option1 is 2-demension array.
			 */
			Option1Utility option1Utility = new Option1Utility();
			
			List<List<Option1Bean>> notSelectedOption1Beans = null;
			List<Option1Bean> option1Beans = null;
			
			/*
			 * Get the option of product.
			 */
			option1Beans = option1DAO.getOptionsAsProductnumber(buyerProductBeans.get(i));
			
			/*
			 * Repackaging the option for easily access.
			 */
			notSelectedOption1Beans = option1Utility.repackagingOption(option1Beans);
			
			
			/*
			 * add(selectedOption1Beans)
			 */
			buyerOption1Beans.add(option1Utility.removeNotselectedOption(notSelectedOption1Beans, buyerOrderListBeans.get(i).getOptions()));
			
		}
		
		/*
		 * Get seller options.
		 */
		for(int i = 0; i < sellerProductBeans.size(); i++) {
			/*
			 * Option1 is 2-demension array.
			 */
			Option1Utility option1Utility = new Option1Utility();
			
			List<List<Option1Bean>> notSelectedOption1Beans = null;
			List<Option1Bean> option1Beans = null;
			
			/*
			 * Get the option of product.
			 */
			option1Beans = option1DAO.getOptionsAsProductnumber(sellerProductBeans.get(i));
			
			/*
			 * Repackaging the option for easily access.
			 */
			notSelectedOption1Beans = option1Utility.repackagingOption(option1Beans);
			
			
			/*
			 * add(selectedOption1Beans)
			 */
			sellerOption1Beans.add(option1Utility.removeNotselectedOption(notSelectedOption1Beans, sellerOrderListBeans.get(i).getOptions()));
			
		}
		option1DAO.close();

		request.getSession().setAttribute("buyerOrderListBeans", buyerOrderListBeans);
		request.getSession().setAttribute("buyerProductBeans", buyerProductBeans);
		request.getSession().setAttribute("buyerOption1Beans", buyerOption1Beans);
		
		request.getSession().setAttribute("sellerOrderListBeans", sellerOrderListBeans);
		request.getSession().setAttribute("sellerProductBeans", sellerProductBeans);
		request.getSession().setAttribute("sellerOption1Beans", sellerOption1Beans);
		
		/*
		 * Order list is called with other data.
		 * so not return ActionForward.
		 */
		return null;
	}

}
