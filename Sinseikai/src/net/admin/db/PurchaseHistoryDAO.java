package net.admin.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		try {
			stmt = con.createStatement();
			stmt.executeQuery("select * from purchasehistory");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				PurchaseHistoryBean bean = new PurchaseHistoryBean();

				bean.setNumber(rs.getInt("number"));
				bean.setBrandName(rs.getString("brandname"));
				bean.setModelNumber(rs.getString("modelnumber"));
				bean.setModelName(rs.getString("modelname"));
				bean.setCoupon(rs.getBoolean("coupon"));
				bean.setPrice(rs.getInt("price"));
				bean.setDiscountRate(rs.getFloat("discountrate"));
				bean.setRating(rs.getFloat("rating"));
				bean.setDeliveryPeriod(rs.getInt("deliveryperiod"));
				bean.setCategoryCode(rs.getInt("categorycode"));
				
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