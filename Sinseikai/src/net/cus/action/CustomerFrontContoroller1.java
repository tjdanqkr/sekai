package net.cus.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.MemberAddAction;
import net.member.loginAction;

/**
 * Servlet implementation class MemberFrontContoroller1
 */

public class CustomerFrontContoroller1 extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("aaa");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		if (command.equals("/cus.cus")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/custem.jsp");
			try {
				request.setAttribute("contentPage", request.getParameter("contentPage"));
				String contentPage = request.getAttribute("contentPage") + "";
				System.out.println(contentPage + "adad");
				if (contentPage.equals("qothd.cus")) {
					action = new cuga();
					System.out.println("디비안됨");
					request.setAttribute("contentPage", "qothdghkrdls.jsp");
					action.execute(request, response);
				}
			} catch (Exception e) {
				// TODO: handle exception

			}
			
		} else if(command.equals("/detail.cus")) {
			action  = new DetailAction();
			System.out.println("vava");
			   try {
				   forward=action.execute(request, response );
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

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
