package net.member.action;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.member.db.MemberDAO;
import net.member.db.MemberBean;

public class MemberAddAction implements Action {
	String address = "";
	@Override
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		MemberDAO memberdao=new MemberDAO();
	   	MemberBean memberdata=new MemberBean();
	   	ActionForward forward=new ActionForward();
	   	boolean result=false;
	   	System.out.println("ddd");
   		int age= Integer.parseInt(request.getParameter("age"));
   			try{
   				memberdata.setPhone(request.getParameter("phone"));
   				memberdata.setAddress(request.getParameter("post")+request.getParameter("roadAddress"));
   				memberdata.setPw(request.getParameter("pw"));
   				memberdata.setEmail(request.getParameter("email"));
   				memberdata.setName(request.getParameter("name"));
   				memberdata.setNum1(Integer.parseInt(request.getParameter("num1")));
   				memberdata.setAge(age);
   				
   		   		result=memberdao.memberInsert(memberdata);
   		   	if(result==false){
	   			System.out.println("�Խ��� ��� ����");
	   			return null;
	   		}
	   		System.out.println("�Խ��� ��� �Ϸ�");
   		   	forward.setRedirect(true);
	   		forward.setPath("/login.me");
	   		
	   		return forward;
   			}catch(Exception ex){
   	   			ex.printStackTrace();
   	   		}
		return null;
	}

}
