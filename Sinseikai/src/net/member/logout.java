package net.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class logout implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ss");
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		session.removeAttribute("name");
		System.out.println("dd");
		System.out.println("�Խ��� ��� ����");
		forward.setRedirect(true);
		forward.setPath("./product_into.pr");
		 
			
		return forward;
		
	}
	// TODO: handle exception

	
}
