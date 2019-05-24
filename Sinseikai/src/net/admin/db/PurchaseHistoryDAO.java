package net.admin.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import net.db.DAO;

import javax.naming.Context;
import javax.naming.InitialContext;

public class PurchaseHistoryDAO implements DAO{ 
	Connection con;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	public PurchaseHistoryDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
		}catch(Exception e) {
			System.out.println("Failed connect DB: " + e);
			return;
		}
	}
	
	// Get purchase history.
	public List<PurchaseHistoryBean> getHistory() {
		List<PurchaseHistoryBean> beans = new ArrayList<PurchaseHistoryBean>();
		
		/*
		 * Used that convert from string to date with hour, minute, second.
		 */
		String purchasedate_string = "";
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		try {
			stmt = con.createStatement();
			
			/*
			 * The date of purchase history is need hour, minute, second.
			 * so get date as string type using 'to_char'.
			 * and change to date type using SimpleDateFormat.
			 */
			rs = stmt.executeQuery("select ph.*, to_char(purchasedate, 'yyyy/mm/dd hh24:mi:ss') purchasedateall "
					+ "from purchasehistory ph order by purchasedateall desc");
			
			while(rs.next()) {
				PurchaseHistoryBean bean = new PurchaseHistoryBean();
				bean.setProductNumber(rs.getInt("productnumber"));
				bean.setBrandName(rs.getString("brandname"));
				bean.setModelNumber(rs.getString("modelnumber"));
				bean.setModelName(rs.getString("modelname"));
				bean.setCoupon(rs.getBoolean("coupon"));
				bean.setFullPrice(rs.getInt("fullprice"));
				bean.setDiscountRate(rs.getFloat("discountrate"));
				bean.setRating(rs.getFloat("rating"));
				bean.setDeliveryPeriod(rs.getInt("deliveryperiod"));
				bean.setCategoryCode(rs.getInt("categorycode"));
				
				purchasedate_string = rs.getString("purchasedateall");
				try {
					/*
					 * Convert string to date.
					 */
					bean.setPurchaseDate(dateFormat.parse(purchasedate_string));
				} catch (ParseException pE) {
					// TODO Auto-generated catch block
					pE.printStackTrace();
					return null;
				}
				
				beans.add(bean);
			}
			
			return beans;
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		return null;
	}
	
	public void close() {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}