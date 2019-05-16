package net.cus.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.cus.db.cusbean;
import net.cus.db.cusdao;
import net.member.db.MemberBean;
import net.member.db.MemberDAO;
import net.member.db.NaverBean;

public class Die implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		MemberDAO medao = new MemberDAO();
		MemberBean mebean = new MemberBean();
		NaverBean nabean= new NaverBean();
		ActionForward forward = new ActionForward();
		boolean result = false;
		
		try {
			
			mebean.setEmail(session.getAttribute("Email")+"");
			result= medao.dieinf(mebean);
			session.setAttribute("email", mebean.getEmail());
			session.setAttribute("phone", mebean.getPhone());
			System.out.println(result+"리졸튼");
			if(result==false) {
				
				nabean.setId(session.getAttribute("id")+"");
				result=medao.dieinfN(nabean);
				session.setAttribute("email", nabean.getEmail());
				session.setAttribute("phone", nabean.getPhone());
				
			}
			medao.close();
			
			forward.setRedirect(false);
			forward.setPath("./member/qothdghkrdls.jsp");
			System.out.println(session.getAttribute("phone"));
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return null;
	}

}
