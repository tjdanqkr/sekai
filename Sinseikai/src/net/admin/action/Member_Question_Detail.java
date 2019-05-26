package net.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.cus.db.DieBean;
import net.cus.db.DieDAO;

public class Member_Question_Detail implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		System.out.println("디테일");
		DieDAO diedao = new DieDAO();
		HttpSession session = request.getSession();
		DieBean diebean = new DieBean();
		ActionForward forward = new ActionForward();
		boolean result = false;
		try {
			
			String title=request.getParameter("title");
			String email= request.getParameter("email");
			String id=request.getParameter("id");
			diebean.setTitle(title);
			diebean.setId(id);
			diebean.setEmail(email);
			diebean= diedao.adminDetaildie(diebean);
			diedao.close();
			
			session.setAttribute("detailbean", diebean);
			forward.setRedirect(false);
			forward.setPath("./admin/Member-qna-reple.jsp");
			return forward;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
