package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class idch implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO memberdao = new MemberDAO();
		MemberBean memberdata = new MemberBean();
		ActionForward forward = new ActionForward();
		boolean result = false;
		try {
			String email = request.getParameter("id");
			memberdata.setEmail(email);
			result = memberdao.idCheck(memberdata);
			if (result == false) {
				System.out.println("�Խ��� ��� ����");
				forward.setRedirect(true);
				forward.setPath("./idch2.me");
			} else {
				System.out.println("�Խ��� ��� �Ϸ�");
				forward.setRedirect(true);
				forward.setPath("./idch1.me");
			}
			return forward;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
