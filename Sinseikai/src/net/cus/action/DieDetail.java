package net.cus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.cus.db.DieBean;
import net.cus.db.DieDAO;
import net.cus.db.cusbean;
import net.cus.db.cusdao;

public class DieDetail implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		DieDAO diedao = new DieDAO();
		HttpSession session = request.getSession();
		DieBean diebean = new DieBean();
		ActionForward forward = new ActionForward();
		boolean result = false;
		try {
			
			String title=request.getParameter("title");
			String email= session.getAttribute("Email")+"";
			String id= session.getAttribute("id")+"";
			System.out.println(id);
			System.out.println(title);
			diebean.setTitle(title);
			diebean.setId(id);
			diebean= diedao.Detaildie(diebean);
			diedao.close();
			System.out.println(diebean.getPhone());
			session.setAttribute("detailbean", diebean);
			forward.setRedirect(false);
			forward.setPath("./member/DieDetail.jsp");
			return forward;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}

}
