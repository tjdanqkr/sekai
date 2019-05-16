package net.product.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.MenuBean;
import net.product.db.MenuDAO;

public class CategoryMenuAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MenuDAO dao = new MenuDAO();
		HttpSession session = request.getSession();
		List<MenuBean> beans = null;
		
		beans = dao.getMenu();
		
		dao.close();
		if(beans == null) {
			System.err.println("ERROR - Failed get the category menu");
			return null;
		}		
    
		request.setAttribute("menuBeans", repackaging(beans)); // Put the result.
		
		return null;
	}
	
	// Category menu is 3D list. so, repackaging the beans.
	private List<List<List<MenuBean>>> repackaging(List<MenuBean> beans) {
		List<List<List<MenuBean>>> majorBeans = new ArrayList<List<List<MenuBean>>>();
		List<List<MenuBean>> minorBeans = null;
		List<MenuBean> categoryBeans = null;
		
		for(MenuBean bean : beans) {
			int majorIndex = checkMajor(majorBeans, bean);
			
			if(majorIndex != -1) { // Exist major category.
				int minorIndex = checkMinor(majorBeans.get(majorIndex), bean);
				
				if(minorIndex != -1) { // Exist minor category.
					majorBeans.get(majorIndex).get(minorIndex).add(bean); // categoryBeans.get(bean)
				}
				else { // New minor category!
					categoryBeans = new ArrayList<MenuBean>();
					categoryBeans.add(bean);
					majorBeans.get(majorIndex).add(categoryBeans); // minorBeans.get(categoryBeans)
				}
			}
			else { // New major category!
				categoryBeans = new ArrayList<MenuBean>();
				categoryBeans.add(bean);
				minorBeans = new ArrayList<List<MenuBean>>();
				minorBeans.add(categoryBeans);
				majorBeans.add(minorBeans);
			}
		}

		return majorBeans;
	}
	private int checkMajor(List<List<List<MenuBean>>> majorBeans, MenuBean bean) {
		for(int i = 0; i < majorBeans.size(); i++) {
			String majorName = majorBeans.get(i).get(0).get(0).getMajorName();
			if(majorName.equals(bean.getMajorName())) {
				return i; // Exist major category.
			}
		}
		
		return -1; // New major category!
	}
	private int checkMinor(List<List<MenuBean>> minorBeans, MenuBean bean) {
		for(int i = 0; i < minorBeans.size(); i++) {
			String minorName = minorBeans.get(i).get(0).getMinorName();
			if(minorName.equals(bean.getMinorName())) {
				return i; // Exist minor category.
			}
		}
		
		return -1; // New minor category!
	}

}