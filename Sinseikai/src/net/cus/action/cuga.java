package net.cus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.cus.db.cusbean;
import net.cus.db.cusdao;



public class cuga implements Action{

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
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
		return null;
	}
}
