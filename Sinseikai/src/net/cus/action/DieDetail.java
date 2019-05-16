package net.cus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		DieBean diebean = new DieBean();
		ActionForward forward = new ActionForward();
		boolean result = false;
		try {
			String title=request.getParameter("title");
			diebean.setTitle(title);
			diebean= diedao.Detaildie(diebean);
			diedao.close();
			request.setAttribute("detailbean", diebean);
			forward.setRedirect(false);
			forward.setPath("./member/DieDetail.jsp");
			return forward;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}

}
