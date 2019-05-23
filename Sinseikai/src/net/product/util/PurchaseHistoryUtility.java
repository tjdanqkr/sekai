package net.product.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.admin.db.PurchaseHistoryBean;

public class PurchaseHistoryUtility {
	public Map<String, Map<String, Integer>> counting(List<PurchaseHistoryBean> beans, String referenceColumn) {
		Map<String, Map<String, Integer>> maps = new HashMap<String, Map<String, Integer>>();
		
		List<PurchaseHistoryBean> dailyBeans = null;
		List<PurchaseHistoryBean> weeklyBeans = null;
		
		/*
		 * Divide as date.
		 */
		dailyBeans = extractDailyData(beans);
		weeklyBeans = extractWeeklyData(beans);
		
		/*
		 * Divide as reference.
		 */
		switch (referenceColumn) {
		case "brandName":
			maps.put("dailyMap", countingAsBrandName(dailyBeans));
			maps.put("weeklyMap", countingAsBrandName(weeklyBeans));
			break;
		default:
			System.err.println("Not support column : " + referenceColumn);
		}
		
		return maps;
	}
	
	/*
	 * Daily data.
	 */
	private List<PurchaseHistoryBean> extractDailyData(List<PurchaseHistoryBean> beans) {
		List<PurchaseHistoryBean> dailyBeans = new ArrayList<PurchaseHistoryBean>();
		
		Calendar calendar = Calendar.getInstance();
		
		int todayDate = calendar.get(Calendar.DATE);
		
		for(PurchaseHistoryBean bean : beans) {
			calendar.setTime(bean.getPurchaseDate());
			
			if(calendar.get(Calendar.DATE) != todayDate) {
				break;
			}
			
			/*
			 * This bean is today bean.
			 */
			dailyBeans.add(bean);
		}
		
		return dailyBeans;
	}
	
	/*
	 * Weekly data.
	 */
	private List<PurchaseHistoryBean> extractWeeklyData(List<PurchaseHistoryBean> beans) {
		List<PurchaseHistoryBean> weeklyBeans = new ArrayList<PurchaseHistoryBean>();
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		
		/*
		 * Date of first day of this week.
		 */
		int sundayDate = calendar.get(Calendar.DATE);
		
		for(PurchaseHistoryBean bean : beans) {
			calendar.setTime(bean.getPurchaseDate());
			
			if(calendar.get(Calendar.DATE) < sundayDate) {
				break;
			}
			
			/*
			 * This bean is this week bean.
			 */
			weeklyBeans.add(bean);
		}
		
		return weeklyBeans;
	}
	
	/*
	 * Counting as specified variable.
	 */
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
