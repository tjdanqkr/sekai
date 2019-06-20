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
import net.product.db.MenuBean;
import net.product.db.MenuDAO;
import net.product.db.Option1Bean;
import net.product.db.Option1DAO;
import net.product.db.ProductBean;
import net.product.db.ProductDAO;

public class BrandgetAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<CodexBrandBean> list ;
		List<MenuBean> clist;
		boolean result = false;
		request.setCharacterEncoding("UTF-8");
		CodexBrandBean cdbean= new CodexBrandBean();
		CodexBrandDAO cddao  =new CodexBrandDAO();
		ActionForward forward = new ActionForward();
		MenuBean menubean = new  MenuBean();
		MenuDAO menudao = new MenuDAO();
		
		
		try {
			cdbean.getBrandName();
			menubean.getCategoryCode();
			
			list=cddao.brandpull(cdbean);
			clist=menudao.categoryPull(menubean);
			cddao.close();
			menudao.close();
		}catch(Exception ex){
   			ex.printStackTrace();
   			cddao.close();
   			menudao.close();
   			System.out.println("카테고리코드, 브랜드 가져오기 에러 ㅅㄱ");
   			return null;
   		}	
			
			
		request.setAttribute("brandolist",list) ;
		request.setAttribute("categorycodelist", clist);
		
		
	   	forward.setRedirect(false);
   		forward.setPath("/product/productInput.jsp");
   		
   		return forward;
	}
	
}