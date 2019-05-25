package net.admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.cus.db.DieBean;
import net.cus.db.DieDAO;


public class Member_Question implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DieDAO dieDAO = new DieDAO();
		DieBean dieBean = new DieBean();
	   	ActionForward forward=new ActionForward();
	   	List dielist = new ArrayList();
	   	try {
			dielist = dieDAO.adminList(dieBean);
			dieDAO.close();
			if(dielist==null) {
				return null;
			}
			request.setAttribute("boardlist", dielist);
			request.setAttribute("centerUri", "/admin/MemberQuestion.jsp");
			forward.setRedirect(false);
			forward.setPath("/admin/adminContainer.jsp");
	   		
			return forward;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}

}
