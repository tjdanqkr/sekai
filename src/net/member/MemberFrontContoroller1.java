package net.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberFrontContoroller1
 */

public class MemberFrontContoroller1 extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
		 	throws ServletException, IOException {
			 
			 String RequestURI=request.getRequestURI();
			 String contextPath=request.getContextPath();
			 String command=RequestURI.substring(contextPath.length());
			 ActionForward forward=null;
			 Action action=null;
			 if(command.equals("/MemberAddAction.me")){
				 action  = new MemberAddAction();
				   try {
					   forward=action.execute(request, response );
				   } catch (Exception e) {
					   e.printStackTrace();
				   }
			   }else if(command.equals("/login.me")){
				   forward=new ActionForward();
				   forward.setRedirect(false);
				   forward.setPath("/Login.jsp");
			   }else if(command.equals("/join.me")){
				   forward=new ActionForward();
				   forward.setRedirect(false);
				   forward.setPath("/Join.jsp");
			   }else if(command.equals("/loginAction.me")){
				   action  = new loginAction();
				   try {
					   forward=action.execute(request, response );
				   } catch (Exception e) {
					   e.printStackTrace();
				   }
			   }else if(command.equals("/idch.me")){
				   action  = new idch();
				   try {
					   forward=action.execute(request, response );
				   } catch (Exception e) {
					   e.printStackTrace();
				   }
			   }else if(command.equals("/idch1.me")){
				   forward=new ActionForward();
				   forward.setRedirect(false);
				   forward.setPath("/idch.jsp");
			   }else if(command.equals("/idch2.me")){
				   forward=new ActionForward();
				   forward.setRedirect(false);
				   forward.setPath("/idch2.jsp");
			   }
			 if(forward.isRedirect()){
				   response.sendRedirect(forward.getPath());
			   }else{
				   RequestDispatcher dispatcher=
					   request.getRequestDispatcher(forward.getPath());
				   dispatcher.forward(request, response);
			   }
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
