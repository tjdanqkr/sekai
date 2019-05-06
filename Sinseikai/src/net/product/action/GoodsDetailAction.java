package net.product.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.CodexBrandBean;
import net.product.db.CodexBrandDAO;
import net.product.db.Option1Bean;
import net.product.db.Option1DAO;
import net.product.db.ProductBean;
import net.product.db.ProductDAO;

public class GoodsDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductDAO productDAO = new ProductDAO();
		Option1DAO option1DAO = null;
		CodexBrandDAO codexBrandDAO = null;
		
		ProductBean productBean = new ProductBean();
		List<Option1Bean> option1Beans = null;
		CodexBrandBean codexBrandBean = null;
		
		productBean.setProductNumber(Integer.parseInt(request.getParameter("productNumber")));
		
		productBean = productDAO.getProductAsProductnumber(productBean); // Get product as productnumber.
		productDAO.close();
		if(productBean == null) {
			System.err.println("ERROR - Failed get the product");
			return null;
		}
		
		option1DAO = new Option1DAO();
		option1Beans = option1DAO.getOptionsAsProductnumber(productBean); // Get options as productnumber.
		option1DAO.close();
		if(option1Beans == null) {
			System.err.println("ERROR - Failed get the options of product");
			return null;
		}
		
		codexBrandDAO = new CodexBrandDAO();
		codexBrandBean = codexBrandDAO.getBrandcodeAsBrandname(codexBrandBean); // Get brandcode as brandname.
		codexBrandDAO.close();
		if(codexBrandBean == null) {
			System.err.println("ERROR - Failed get the brandcode");
			return null;
		}
		
		request.setAttribute("productBean", productBean); // Put the result.
		request.setAttribute("option1Beans", repackagingOption(option1Beans));
		request.setAttribute("codexBrandBean", codexBrandBean);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("."); // set at after.
		return forward;
	}

	// Option of product is 2D list. so, repackaging the beans.
	private List<List<Option1Bean>> repackagingOption(List<Option1Bean> beans) {
		List<List<Option1Bean>> majorBeans = new ArrayList<List<Option1Bean>>();
		List<Option1Bean> minorBeans = null;
		
		for(Option1Bean bean : beans) {
			int majorIndex = checkMajor(majorBeans, bean);
			
			if(majorIndex != -1) { // Exist major category.
				majorBeans.get(majorIndex).add(bean);
			}
			else { // New major category!
				minorBeans = new ArrayList<Option1Bean>();
				minorBeans.add(bean);
				majorBeans.add(minorBeans);
			}
		}

		return majorBeans;
	}
	private int checkMajor(List<List<Option1Bean>> majorBeans, Option1Bean bean) {
		for(int i = 0; i < majorBeans.size(); i++) {
			String majorName = majorBeans.get(i).get(0).getMajorName();
			if(majorName.equals(bean.getMajorName())) {
				return i; // Exist major category.
			}
		}
		
		return -1; // New major category!
	}
	
}
