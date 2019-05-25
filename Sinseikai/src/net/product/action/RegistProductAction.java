package net.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.*;

public class RegistProductAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		ProductBean productbean = new ProductBean();
		ProductDAO productdao = new ProductDAO();
		ActionForward forward = new ActionForward();
		boolean result=false;	
		try {
			int productNumber = Integer.parseInt(request.getParameter("productNumer"));
			int price = Integer.parseInt(request.getParameter("productNumer"));
			int discountRate=Integer.parseInt(request.getParameter("productNumer"));
			int rating=Integer.parseInt(request.getParameter("productNumer"));
			int deliberyPeriod=Integer.parseInt(request.getParameter("productNumer"));
			productbean.setBrandName(request.getParameter("brandName"));
			productbean.setModelNumber(request.getParameter("modelNumber"));
			productbean.setModelName(request.getParameter("modelName"));
			productbean.setCoupon(request.getParameter("coupon"));			
			productbean.setImgAddr1(request.getParameter("imgAdd1"));
			productbean.setImgAddr2(request.getParameter("imgAdd2"));
			productbean.setImgAddr3(request.getParameter("imgAdd3"));
			productbean.setImgAddr4(request.getParameter("imgAdd4"));
			productbean.setImgAddr5(request.getParameter("imgAdd5"));
			productbean.setSellerEmail(request.getParameter("sellerEmail"));
			productbean.setProductNumber(productNumber);
			productbean.setProductNumber(price);
			productbean.setProductNumber(discountRate);
			productbean.setProductNumber(rating);
			productbean.setProductNumber(deliberyPeriod);
			
			result=productdao.productInsert(productbean);
			if(result==false){
	   			System.out.println("�Խ��� ��� ����");
	   			return null;
	   		}
	   		System.out.println("�Խ��� ��� �Ϸ�");
   		   	forward.setRedirect(true);
	   		forward.setPath("login.me");
	   		
	   		return forward;
   			}catch(Exception ex){
   	   			ex.printStackTrace();
   	   		}
			return null;
	}

}
