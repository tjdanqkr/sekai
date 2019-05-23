package net.product.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.admin.db.PurchaseHistoryBean;

public class PurchaseHistoryUtility {
	public Map<String, Integer> counting(List<PurchaseHistoryBean> beans, String referenceColumn) {
		Map<String, Integer> map = null;
		
		switch (referenceColumn) {
		case "brandName":
			map = countingAsBrandName(beans);
			break;
		default:
			System.err.println("Not support column : " + referenceColumn);
		}
		
		return map;
	}
	
	private Map<String, Integer> countingAsBrandName(List<PurchaseHistoryBean> beans) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(PurchaseHistoryBean bean : beans) {
			try{
				/*
				 * Exist type.
				 */
				map.put(bean.getBrandName(), map.get(bean.getBrandName()) + 1);
			}catch(NullPointerException nPE) {
				/*
				 * New type!
				 */
				map.put(bean.getBrandName(), 1);
			}
		}
		
		return map;
	}
}
