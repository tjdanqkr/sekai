package net.product.action;

import java.util.ArrayList;
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
import net.product.db.ProductBean;
import net.product.db.ProductDAO;

public class BrandgetAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<CodexBrandBean> list ;
		boolean result = false;
		request.setCharacterEncoding("UTF-8");
		CodexBrandBean cdbean= new CodexBrandBean();
		CodexBrandDAO cddao  =new CodexBrandDAO();
		ActionForward forward = new ActionForward();
		
		try {
			cdbean.getBrandName();
			list=cddao.brandpull(cdbean);
			cddao.close();				
		}catch(Exception ex){
   			ex.printStackTrace();
   			cddao.close();
   			System.out.println("브랜드가져오기에러 ㅅㄱ");
   			return null;
   		}	
			
			
		request.setAttribute("brandolist",list) ;
			
		
		
	   	forward.setRedirect(false);
   		forward.setPath("/product/productInput.jsp");
   		
   		return forward;
	}
	
}