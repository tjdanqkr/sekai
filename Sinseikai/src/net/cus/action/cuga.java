package net.cus.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.cus.db.cusbean;
import net.cus.db.cusdao;

public class cuga implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
<<<<<<< HEAD
		cusdao cusdao = new cusdao();
		cusbean cusbean = new cusbean();
		List boardlist=new ArrayList();
		ActionForward forward = new ActionForward();
		boolean result = false;
		System.out.println("ddd");
		try {
			cusbean.setName(request.getParameter("name"));
			boardlist= cusdao.getList(cusbean);
			
			if (result == false) {
				System.out.println("�Խ��� ��� ����");
				return null;
			}
			System.out.println("�Խ��� ��� �Ϸ�");
			forward.setRedirect(true);
			forward.setPath("./qothdghkrdls.jsp");

			return forward;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
=======
		cusdao cusdao= new cusdao();
		cusbean cusbean= new cusbean();
		
	   	ActionForward forward=new ActionForward();
	   	boolean result=false;
	   	System.out.println("ddd");
   		int age= Integer.parseInt(request.getParameter("age"));
   			try{
   				cusbean.setName(request.getParameter(arg0));
   				
   		   		result=memberdao.memberInsert(memberdata);
   		   	if(result==false){
	   			System.out.println("�Խ��� ��� ����");
	   			return null;
	   		}
	   		System.out.println("�Խ��� ��� �Ϸ�");
   		   	forward.setRedirect(true);
	   		forward.setPath("./qothdghkrdls.jsp");
	   		
	   		return forward;
   			}catch(Exception ex){
   	   			ex.printStackTrace();
   	   		}
>>>>>>> branch 'master' of https://github.com/tjdanqkr/sekai.git
		return null;
	}
}
