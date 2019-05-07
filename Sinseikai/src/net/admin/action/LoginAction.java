package net.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.admin.db.*;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		AdminDAO memberdao = new AdminDAO();
		AdminBean memberdata = new AdminBean();
		ActionForward forward = new ActionForward();
		boolean result = false;
		try {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			memberdata.setId(id);
			memberdata.setPw(pw);
			result = memberdao.Adminlogin(memberdata);
			memberdao.close();
			if (result == false) {
				System.out.println("�Խ��� ��� ����");
				forward.setRedirect(true);
				forward.setPath("./login.ad");
				return forward;
			}
			forward.setRedirect(true);
			forward.setPath("url");
			

			return forward;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}