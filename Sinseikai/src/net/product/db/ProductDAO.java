package net.product.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import net.db.DAO;
import net.product.Menu;

import javax.naming.Context;
import javax.naming.InitialContext;

public class ProductDAO implements DAO{ 
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
			System.out.println("Failed connect DB: " + e);
			return;
		}
	}
	
	// Call the information about one product. 
	public ProductBean getProduct(ProductBean bean) {
		try {
			pstmt = con.prepareStatement("select * from product where productnumber=?");
			pstmt.setInt(1, bean.getProductNumber());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// Excepted from call the setter bacause productNumber is already inserted.
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
	
	// Call the product correct to category.
	public List<ProductBean> getCategoryShop(MenuBean menuBean) {
		List<ProductBean> beans = null;
		try {
			pstmt = con.prepareStatement("select * "
					+ "from (select c0.categorycode from codexcategory c0 where c0.categoryname=?) c "
					+ "inner join product p on c.categorycode = p.categorycode");
			pstmt.setString(1, menuBean.getCategoryName());
			
			rs = pstmt.executeQuery();
			
			beans = new ArrayList<ProductBean>();
			while(rs.next()) { // Put the products correct to category.
				ProductBean bean = new ProductBean();
				
				bean.setProductNumber(rs.getInt("productnumber"));
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