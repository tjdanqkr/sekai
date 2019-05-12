package net.admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.admin.db.AdminMenuBean;
import net.admin.db.AdminMenuDAO;
import net.product.db.MenuBean;

public class AdminMenuAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminMenuDAO dao = new AdminMenuDAO();
		
		List<AdminMenuBean> beans = null;
		
		beans = dao.getAdminMenu();
		dao.close();
		if(beans == null) {
			System.err.println("ERROR - Failed get the admin menu");
			return null;
		}		
    
		/*
		 * Admin menu is need always. so set to session.
		 */
		request.getSession().setAttribute("adminMenuBeans", repackaging(beans)); // Put the result.

		return null;
	}

	// Admin menu is 2D list. so, repackaging the beans.
	private List<List<AdminMenuBean>> repackaging(List<AdminMenuBean> beans) {
		List<List<AdminMenuBean>> majorBeans = new ArrayList<List<AdminMenuBean>>();
		List<AdminMenuBean> nameBeans = null;
		
		for(AdminMenuBean bean : beans) {
			int majorIndex = checkMajor(majorBeans, bean);
			
			if(majorIndex != -1) { // Exist major admin menu.
				majorBeans.get(majorIndex).add(bean); // nameBeans.get(bean)
			}
			else { // New major admin menu!
				nameBeans = new ArrayList<AdminMenuBean>();
				nameBeans.add(bean);
				majorBeans.add(nameBeans);
			}
		}

		return majorBeans;
	}

	private int checkMajor(List<List<AdminMenuBean>> majorBeans, AdminMenuBean bean) {
		for(int i = 0; i < majorBeans.size(); i++) {
			String majorName = majorBeans.get(i).get(0).getMajorName();
			if(majorName.equals(bean.getMajorName())) {
				return i; // Exist major admin menu.
			}
		}
		
		return -1; // New major admin menu!
	}
	
}
