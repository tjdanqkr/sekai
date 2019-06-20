package net.product.util;

import java.util.ArrayList;
import java.util.List;

import net.product.db.Option1Bean;

public class Option1Utility {
	// Option of product is 2D list. so, repackaging the beans.
	public List<List<Option1Bean>> repackagingOption(List<Option1Bean> beans) {
		List<List<Option1Bean>> majorBeans = new ArrayList<List<Option1Bean>>();
		List<Option1Bean> minorBeans = null;
		
		for(Option1Bean bean : beans) {
			int majorIndex = checkMajor(majorBeans, bean);
			
			if(majorIndex != -1) { // Exist major option.
				majorBeans.get(majorIndex).add(bean);
			}
			else { // New major option!
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
				return i; // Exist major option.
			}
		}
		
		return -1; // New major option!
	}
	
	// Table option1 is complex. so, change to HTML in here.
	public String listToHTML(List<List<Option1Bean>> majorBeans) {
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
	public String createJSForOption(List<List<Option1Bean>> majorBeans) {
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
	
	/*
	 * Remove the not selected option.
	 * use the value 'options' of order list. 
	 */
	public List<Option1Bean> removeNotselectedOption(List<List<Option1Bean>> notSelectedBeans, String options) {
		/*
		 * Example
		 * 
		 * notSelectedBeans (2-dimension)
		 *  - Major1
		 *    - minor1
		 *    - minor2
		 *  - Major2
		 *    - minor1
		 *    - ...
		 *  
		 * selectedBeans (1-dimension)
		 *  - minor2 (in Major1)
		 *  - minor1 (in Major2)
		 */
		List<Option1Bean> selectedBeans = new ArrayList<Option1Bean>();

		/*
		 * options is String. (ex : "1, 2, 3")
		 * should convert to int array.
		 */
		String[] optionsArr; 
		
		try{
			/*
			 * No option.
			 */
			optionsArr = options.split(",");
		}catch (NullPointerException npe) {
			return null;
		}
		
		int[] optionsArrInt = new int[options.length()];
		
		/*
		 * Used that find child option of selected parent option.
		 * if no child option, index is -1
		 */
		int[] parentIndex = new int[options.length()];
		
		/*
		 * convert from string to int.
		 */
		for(int i = 0; i < optionsArr.length; i++) {
			optionsArrInt[i] = Integer.parseInt(optionsArr[i].trim());
			
			parentIndex[i] = -1;
		}
		
		for(int i = 0; i < notSelectedBeans.size(); i++) {
			List<Option1Bean> option1Beans = notSelectedBeans.get(i);
			Option1Bean selectedBean = null;
			
			if(parentIndex[i] == -1) {
				/*
				 * No parent.
				 * 
				 * first number of option is 1.
				 * but first number of arr is 0.
				 */
				selectedBean = option1Beans.get(optionsArrInt[i]-1);
			}else {
				/*
				 * Exist parent.
				 */
				selectedBean = getChildOption(option1Beans, parentIndex[i], optionsArrInt[i]);
			}
			
			/*
			 * Add selected option.
			 */
			selectedBeans.add(selectedBean);
			
			setParentIndex(selectedBeans.get(i), notSelectedBeans, parentIndex);
		}
		
		return selectedBeans;
	}
	
	/*
	 * Get child option.
	 */
	private Option1Bean getChildOption(List<Option1Bean> beans, int parentIndex, int minorNumber) {
		Option1Bean bean = null;
		
		for(int i = 0; i < beans.size(); i++) {
			if(beans.get(i).getMinorNumber() == minorNumber && 
					beans.get(i).getPaMajorNumber() == parentIndex) {
				bean = beans.get(i);
				
				break;
			}
		}
		
		return bean;
	}
	
	/*
	 * Set parent index.
	 * for example, child of option3 is option5.
	 * then set parentIndex[2] = 5 (because option first is 1, array first is 0)
	 */
	private void setParentIndex(Option1Bean maybeParent, List<List<Option1Bean>> maybeChildren, int[] parentIndex) {
		for(List<Option1Bean> maybeChild : maybeChildren) {
			if(maybeChild.get(0).getPaMajorNumber() == maybeParent.getMajorNumber()) {
				parentIndex[maybeChild.get(0).getMajorNumber()-1] = maybeParent.getMajorNumber();
				
				return;
			}
		}
	}
	
}
