package net.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.action.Action;
import net.member.action.ActionForward;
import net.product.db.*;

public class registProductAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		ProductBean productbean = new ProductBean();
		ProductDAO productdao = new ProductDAO();
		ActionForward forward = new ActionForward();
		
		try {
			productbean.setBrandName();
			productbean.setCategorycode(0);
			productbean.getCategorycode()
			productbean.getClass();
			productbean.getCoupon();
			productbean.getDiscountRate();
			productbean.getImgAddr1();
			productbean.getImgAddr2();
			productbean.getImgAddr3();
			productbean.getImgAddr4();
			productbean.getImgAddr5();
			productbean.setProductNumber();
			productbean.getBrandName();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
	}

}
