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
import net.member.db.MemberBean;

import javax.naming.Context;
import javax.naming.InitialContext;

public class OrderListDAO implements DAO{ 
	Connection con;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	public OrderListDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
		}catch(Exception e) {
			System.out.println("Failed connect DB: " + e);
			return;
		}
	}
	
	// Get order list for buyer using email of memberBean.
	public List<OrderListBean> getOrderListForBuyer(MemberBean memberBean) {
		List<OrderListBean> orderListBeans = new ArrayList<OrderListBean>();
		try {
			pstmt = con.prepareStatement("select * from orderlist where buyer=?");
			pstmt.setString(1, memberBean.getEmail());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderListBean orderListBean = new OrderListBean();
				
				orderListBean.setOrderId(rs.getString("orderid"));
				orderListBean.setBuyer(rs.getString("buyer"));
				orderListBean.setSeller(rs.getString("seller"));
				orderListBean.setProductNumber(rs.getInt("productnumber"));
				orderListBean.setCoupon(rs.getBoolean("coupon"));
				orderListBean.setPrice(rs.getInt("price"));
				orderListBean.setOption(rs.getString("option"));
				orderListBean.setAmount(rs.getInt("amount"));
				orderListBean.setStatus(rs.getString("status"));
				
				orderListBeans.add(orderListBean);
			}
			
			return orderListBeans;
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