package net.cus.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.cus.db.cusbean;
import net.cus.db.cusdao;

public class DetailAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		cusdao cusdao = new cusdao();
		cusbean cusbean = new cusbean();
		ActionForward forward = new ActionForward();
		boolean result = false;
		try {
			String title=request.getParameter("title");
			cusbean.setTitle(title);
			cusbean= cusdao.Detail(cusbean);
			System.out.println(result);
			cusdao.close();
			System.out.println(cusbean.getCon()+"이건 내용");
			System.out.println(cusbean.getTitle()+"이건 이름");
			request.setAttribute("detailbean", cusbean);
			forward.setRedirect(false);
			forward.setPath("./CusDetail.jsp");
			return forward;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
