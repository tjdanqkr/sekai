package net.cus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.cus.db.DieBean;
import net.cus.db.DieDAO;
import net.cus.db.cusbean;
import net.cus.db.cusdao;

public class DieInsert implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		DieDAO dieDAO= new DieDAO();
		DieBean dieBean= new DieBean();
		ActionForward forward = new ActionForward();
		boolean result = false;
		try {
			String product= "";
			String email= session.getAttribute("email")+"";
			String phone= request.getParameter("ansCellNo");
			String title= request.getParameter("inqTitl");
			String subject= request.getParameter("inqCnts");
			dieBean.setEmail(email);
			dieBean.setPhone(phone);
			dieBean.setProduct(product);
			dieBean.setSubject(subject);
			dieBean.setTitle(title);
			System.out.println("시작");
			result=dieDAO.DieInsert(dieBean);
			if(result==false) {
				return null;
			}
			forward.setRedirect(false);
			forward.setPath("./cus.cus");
			return forward;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return null;
	}

}
