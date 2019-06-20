package net.cus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
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
			String subject;
			String proch= request.getParameter("cbxNotProductInqry");
			String emailch= request.getParameter("ansEmailRecvYn");
			String phonech= request.getParameter("ansSmsRecvYn");
			System.out.println(proch+"프로"+"이메일"+emailch+"폰"+phonech);
			if(proch==null) {
				proch="N";
			}if(emailch==null) {
				emailch="N";
			}if(phonech==null) {
				phonech="N";
			}
			System.out.println(proch+"프로"+"이메일"+emailch+"폰"+phonech);
			String product= "";
			String email= session.getAttribute("email")+" 수신 확인 : "+emailch;
			String phone= request.getParameter("ansCellNo")+" 수신 확인 : "+phonech;
			String title= request.getParameter("inqTitl");
			if(proch.equals("N")) {
				subject= request.getParameter("inqCnts")+"상품 외 문의!";
				}else {
					subject= request.getParameter("inqCnts");
				}
			dieBean.setId(session.getAttribute("id")+"");
			dieBean.setEmail(email);
			dieBean.setPhone(phone);
			dieBean.setProduct(product);
			dieBean.setSubject(subject);
			dieBean.setTitle(title);
			System.out.println("시작");
			result=dieDAO.DieInsert(dieBean);
			dieDAO.close();
			if(result==false) {
				return null;
			}
			forward.setRedirect(true);
			forward.setPath("./cus.cus");
			return forward;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return null;
	}

}
