package net.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.cus.db.DieBean;
import net.cus.db.DieDAO;

public class Member_Reple_Update implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DieDAO diedao = new DieDAO();
		
		DieBean diebean = new DieBean();
		ActionForward forward = new ActionForward();
		boolean result = false;
		try {
			
			diebean.setEmail(request.getParameter("email"));
			diebean.setReple(request.getParameter("reple"));
			diebean.setPhone(request.getParameter("phone"));
			diebean.setTitle(request.getParameter("title"));
			result= diedao.Updatedie(diebean);
			
			diedao.close();
			if(result==false) {
				System.out.println("시류패");
				return null;
			}
			
			forward.setRedirect(true);
			forward.setPath("./admin/Member-qna-close.jsp");
			return forward;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

}
