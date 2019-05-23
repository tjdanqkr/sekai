package net.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.Action;
import net.member.ActionForward;
import net.member.db.*;


public class naverlo implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		MemberDAO memberdao=new MemberDAO();
	   	NaverBean memberdata=new NaverBean();
	   	ActionForward forward=new ActionForward();
	   	HttpSession session = request.getSession();
	   	boolean result=false;
	   	try{
				memberdata.setId(session.getAttribute("id")+"");
				memberdata.setAge(session.getAttribute("age")+"");
				memberdata.setName(session.getAttribute("name")+"");
				memberdata.setEmail(session.getAttribute("email")+"");
				result= memberdao.naverCheck(memberdata);
				session.setAttribute("Email", "");
				if(result==false) {
					
		   		result=memberdao.naverInsert(memberdata);}
				memberdao.close();
		   	if(result==false){
   			System.out.println("�Խ��� ��� ����");
   			return null;
   		}
   		System.out.println("�Խ��� ��� �Ϸ�");
		   	forward.setRedirect(true);
   		forward.setPath("./product-into.pr");
   		
   		return forward;
			}catch(Exception ex){
	   			ex.printStackTrace();
	   		}
	   	System.out.println("안됨");
		return null;
	}

}
