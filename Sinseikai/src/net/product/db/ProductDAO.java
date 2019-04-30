package net.product.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import javax.naming.Context;
import javax.naming.InitialContext;

public class ProductDAO {
	Connection con;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	public ProductDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
		}catch(Exception e) {
			System.out.println("DB 연결 실패: " + e);
			return;
		}
	}
	
	public ProductBean getProduct(ProductBean bean) {
		try {
			pstmt = con.prepareStatement("select * from product where productnumber=?");
			pstmt.setInt(1, bean.getProductNumber());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// productNumber는 이미 들어가있으므로 set함수 호출에서 제외함.
				bean.setBrandName(rs.getString("brandname"));
				bean.setModelNumber(rs.getString("modelnumber"));
				bean.setMedelName(rs.getString("modelname"));
				bean.setCoupon(rs.getString("coupon"));
				bean.setPrice(rs.getInt("price"));
				bean.setDiscountRate(rs.getFloat("discountrate"));
				bean.setRating(rs.getFloat("rating"));
				bean.setImgAddr(rs.getString("imgaddr"));
				bean.setImgAddr2(rs.getString("imgaddr2"));
				bean.setImgAddr3(rs.getString("imgaddr3"));
				bean.setImgAddr4(rs.getString("imgaddr4"));
				bean.setImgAddr5(rs.getString("imgaddr5"));
				bean.setDeliveryPeriod(rs.getInt("deliveryperiod"));
				bean.setCategorycode(rs.getInt("categorycode"));
				return bean;
			}
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