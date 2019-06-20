package net.product.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.member.db.MemberBean;
import net.member.db.MemberDAO;
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
		MemberBean memberBean = new MemberBean();
		MemberDAO memberDAO = new MemberDAO();
		
		memberBean.setEmail(request.getParameter("email"));
		memberBean = memberDAO.kensaku(memberBean);
		memberDAO.close();
		if(memberBean == null) {
			System.err.println("ERROR - Failed get the member");
			return null;
		}
		
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
		codexBrandBean = codexBrandDAO.getBrandcodeAsBrandname(productBean); // Get brandcode as brandname.
		codexBrandDAO.close();
		if(codexBrandBean == null) {
			System.err.println("ERROR - Failed get the brandcode");
			return null;
		}
		
		List<List<Option1Bean>> majorBeans = repackagingOption(option1Beans);
		request.getSession().setAttribute("productBean", productBean); // Put the result.
		request.setAttribute("optionAmount", majorBeans.size());
		request.setAttribute("optionHTML",  listToHTML(majorBeans));
		request.setAttribute("optionJS", createJSForOption(majorBeans));
		request.setAttribute("codexBrandBean", codexBrandBean);
		request.getSession().setAttribute("memberBean", memberBean);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/product/productInto.jsp"); // set at after.
		
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
	
	// Table option1 is complex. so, change to HTML in here.
	private String listToHTML(List<List<Option1Bean>> majorBeans) {
		String html = "";
				
		for(List<Option1Bean> minorBeans : majorBeans) {
			if(minorBeans.get(0).getPaMajorNumber() == 0) {
				html += createIndependentSelectElement(minorBeans, majorBeans);
			}else {
				html += createDependentSelectElement(minorBeans, majorBeans);
			}
			html += "<br />\n";
		}
		
		return html;
	}
	
	/*
	 * All options have possibility that they is parent.
	 * argument majorBeans is used to that confirm the options is parent. 
	 */
	private String createIndependentSelectElement(List<Option1Bean> minorBeans, List<List<Option1Bean>> majorBeans) {
		// This option can select freely.
		
		// Example) <select name="option1">
		String html = "<select name=\"option" + minorBeans.get(0).getMajorNumber() + "\">\n";
		
		// Basic option.
		html += "<option value=\"0\">" + "</option>\n";
		
		// Example) <option value="1">first</option>
		for(Option1Bean bean : minorBeans) {
			html +=  "<option value=\"" + bean.getMinorNumber() + "\">" +
					bean.getMinorName();
			
			if(!isExistChildOption(bean, majorBeans)) {
			//	html += " " + bean.getMinorStock() + "개";
			}
			
			html += "</option>\n";
		}
		
		html += "</select>\n";
		
		return html;
	}
	
	/*
	 * All options have possibility that they is parent.
	 * argument majorBeans is used to that confirm the options is parent. 
	 */
	private String createDependentSelectElement(List<Option1Bean> minorBeans, List<List<Option1Bean>> majorBeans) {
		// This option can select after parent option is selected.
		
		String html = "";
		
		int index = 0;
		
		// Basic option.
		html += "<select name=\"option" + minorBeans.get(0).getMajorNumber()+"\">\n";
		html += "<option value=\"0\">"  + "</option>\n";
		html += "</select>\n";
		
		for(int i = 0; i < minorBeans.size(); i++) {
			if(minorBeans.get(i).getPaMinorNumber() != index) {
				
				// Example) <select name="option2">
				html += "<select name=\"option" + minorBeans.get(0).getMajorNumber()+"\" " + 
						"style=\"display: none;\">\n";
				
				html += "<option value=\"0\">" + "</option>\n";
				
				if(minorBeans.get(i).getPaMinorNumber() != index + 1) {
					// Sadly, this parent option has no child option at this time.
					html += "</select>\n";
					i--;
					index++;
					
					continue;
				}
				index = minorBeans.get(i).getPaMinorNumber();
			}
			
			// Example) <option value="1">small</option>
			html += "<option value=\"" + minorBeans.get(i).getMinorNumber() + "\">" + 
					minorBeans.get(i).getMinorName();
			
			if(!isExistChildOption(minorBeans.get(i), majorBeans)) {
			//	html += " "+minorBeans.get(i).getMinorStock() ;
			}
			
			html += "</option>\n";
			
			try {
				if(minorBeans.get(i+1).getPaMinorNumber() != index) {
					html += "</select>\n"; // End of option that parent is equal.
				}
			}catch(IndexOutOfBoundsException ioobe) {
				html += "</select>\n"; // Last option.
			}
		}
		return html;
	}
	
	// Create the java script for option.
	private String createJSForOption(List<List<Option1Bean>> majorBeans) {
		String js = "";
		
		for(List<Option1Bean> minorBeans : majorBeans) {
			for(List<Option1Bean> maybeChildBeans : majorBeans) {
				if(maybeChildBeans.get(0).getPaMajorNumber() == minorBeans.get(0).getMajorNumber()) {
					// Should create the java script.
					int parentNum = minorBeans.get(0).getMajorNumber();
					int childNum = maybeChildBeans.get(0).getMajorNumber();
					
					// Ready the addEventListener.
					js += "var options" + parentNum + 
							"= document.getElementsByName('option" + parentNum + "');\n";
					
					// AddEventListener.
					js += "for(var i = 0; i < options" + parentNum + ".length; i++){\n" + 
						      "\toptions" + parentNum + "[i].addEventListener('change', function(){\n" + 
							      "\t\tshowOption" + childNum + "(this.value);\n" + 
						      "\t});\n" + 
						  "}\n";
					
					// function hideOptions
					js += "function hideOptions" + childNum + "(){\n" +
						      "\tvar options = document.getElementsByName('option" + childNum + "');\n" +
						      "\tfor(var i = 0; i < options.length; i++){\n" +
						          "\t\toptions[i].value = 0;\n" + 
						          "\t\toptions[i].style.display = 'none';\n" + 
						      "\t}\n" + 
						  "}\n";
					
					// function showOption
					js += "function showOption" + childNum + "(value){\n" +
						      "\thideOptions" + childNum + "();\n" + 
						      "\tdocument.getElementsByName('option" + childNum + 
						      "')[value].style.display = 'inline';\n" + 
						  "}";
				}
			}
		}
		
		return js;
	}
	private boolean isExistChildOption(Option1Bean maybeParent, List<List<Option1Bean>> maybeChildren) {
		for(List<Option1Bean> maybeChild : maybeChildren) {
			if(maybeChild.get(0).getPaMajorNumber() == maybeParent.getMajorNumber()) {
				return true;
			}
		}
		return false;
	}
}
