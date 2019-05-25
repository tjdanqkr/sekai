package net.admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.member.db.*;
public class Member_Lookup implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO memberdao=new MemberDAO();
	   	MemberBean memberdata=new MemberBean();
	   	ActionForward forward=new ActionForward();
	   	List<MemberBean> list = new ArrayList<MemberBean>();
		List<NaverBean> list1 = new ArrayList<NaverBean>();
	   	try {
	   		list=memberdao.Memberlookup();
	   		memberdao.close();
	   		if(list==null) {
	   			System.out.println("멤버 오류");
	   			return null;
	   		}
	   		request.setAttribute("memberlist", list);
			/*
			 * list1=memberdao.Naberlookup(); if(list1==null) {
			 * System.out.println("네이버 멤버 오류"); return null; }
			 * request.setAttribute("naverlist", list);
			 */
	   		
	   		request.setAttribute("centerUri", "/admin/MemberList.jsp");
			
			
			forward.setRedirect(false);
			forward.setPath("/admin/adminContainer.jsp");
	   		
	   		return forward;
	   	}catch (Exception e) {
			// TODO: handle exception
		}
	   	
		
		return null;
	}

}
