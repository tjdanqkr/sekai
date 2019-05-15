package net.cus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;
import net.member.db.NaverBean;

public class MeUpdate implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	request.setCharacterEncoding("UTF-8");
	HttpSession session = request.getSession();
	MemberDAO medao = new MemberDAO();
	MemberBean mebean = new MemberBean();
	NaverBean nabean = new NaverBean();
	ActionForward forward = new ActionForward();
	boolean result = false;
	try {
		String email=session.getAttribute("email")+"";
		String phone= request.getParameter("phone");
		mebean.setEmail(email);
		mebean.setPhone(phone);
		result=medao.memberupdate(mebean);
		if(result==false) {
			nabean.setId(session.getAttribute("id")+"");
			medao.memberupdateN(nabean);
		}
		medao.close();
		session.setAttribute("phone", phone);
		if(result==true) {
			forward.setRedirect(true);
			forward.setPath("./cus.cus");
			return forward;
		}
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	
	return null;
	}
}
