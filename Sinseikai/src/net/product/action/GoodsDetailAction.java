package net.product.action;

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
		request.setAttribute("option1Beans", option1Beans);
		request.setAttribute("codexBrandBean", codexBrandBean);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("."); // set at after.
		return forward;
	}

}
