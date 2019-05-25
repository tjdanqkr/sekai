package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;


public class logout implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ss");
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		session.removeAttribute("name");
		session.removeAttribute("id");
		System.out.println("dd");
		System.out.println("빠이 짜이찌엔");
		forward.setRedirect(true);
		forward.setPath("./product-into.pr");
		 
			
		return forward;
		
	}
	// TODO: handle exception

	
}
