
package net.cus.action;




import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.member.MemberAddAction;
import net.member.loginAction;
import net.product.action.CategoryMenuAction;


public class CustomerFrontContoroller1 extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		HttpSession session = request.getSession();

		action = new CategoryMenuAction();

		

		
		if (command.equals("/cus.cus")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/custem.jsp");
			try {
				request.setAttribute("contentPage", request.getParameter("contentPage"));
				String contentPage = request.getAttribute("contentPage") + "";
				
				if (contentPage.equals("qothd.cus")) {
					action = new cuga();
					request.setAttribute("contentPage", "qothdghkrdls.jsp");
				}else if (contentPage.equals("diedie.cus")){
					action = new Die();
					request.setAttribute("contentPage", "DieDieCenter.jsp");
				}else if (contentPage.equals("diedieok.cus")){
					action = new DieCh();
					request.setAttribute("contentPage", "DieCh.jsp");
				}
				action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception

			}
			
		} else if(command.equals("/detail.cus")) {
			action  = new DetailAction();
			   try {
				   forward=action.execute(request, response );
			   } catch (Exception e) {
				   e.printStackTrace();
			   }
		}else if(command.equals("/detaildie.cus")) {
			action  = new DieDetail();
			   try {
				   forward=action.execute(request, response );
			   } catch (Exception e) {
				   e.printStackTrace();
			   }
		} else if(command.equals("/update.cus")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/CusUpdate.jsp");
		}else if(command.equals("/updateme.cus")) {
			action  = new MeUpdate();
			   try {
				   forward=action.execute(request, response);
			   } catch (Exception e) {
				   e.printStackTrace();
			   }
		}else if(command.equals("/diedieinsert.cus")) {
			action  = new DieInsert();
			   try {
				   forward=action.execute(request, response);
			   } catch (Exception e) {
				   e.printStackTrace();
			   }
		}

		if (forward.isRedirect()) {
			
			response.sendRedirect(forward.getPath());
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		}
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}


}




