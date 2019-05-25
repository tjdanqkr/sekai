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
	
	/*
	 * Get order list for buyer using email of memberBean.
	 */
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
				orderListBean.setOptions(rs.getString("options"));
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
	
	/*
	 * Get order list for seller using email of memberBean.
	 */
	public List<OrderListBean> getOrderListForSeller(MemberBean memberBean) {
		List<OrderListBean> orderListBeans = new ArrayList<OrderListBean>();
		try {
			pstmt = con.prepareStatement("select * from orderlist where seller=?");
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
				orderListBean.setOptions(rs.getString("options"));
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
	
	/*
	 * Insert to orderList using buyer.
	 */
	public boolean insertOrderList(OrderListBean bean) {
		try {
			pstmt = con.prepareStatement(
					"insert into orderlist values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			pstmt.setString(1, bean.getOrderId());
			pstmt.setString(2, bean.getBuyer());
			pstmt.setString(3, bean.getSeller());
			pstmt.setInt(4, bean.getProductNumber());
			pstmt.setBoolean(5, bean.isCoupon());
			pstmt.setInt(6, bean.getPrice());
			pstmt.setString(7, bean.getOptions());
			pstmt.setInt(8, bean.getAmount());
			pstmt.setString(9, bean.getStatus());
			
			if(pstmt.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		return false;
	}
	
	/*
	 * Update status of one order list.
	 */
	public boolean updateOrderListStatus(OrderListBean bean) {
		try {
			pstmt = con.prepareStatement("update orderlist set status=? where orderid=?");
			
			pstmt.setString(1, bean.getStatus());
			pstmt.setString(2, bean.getOrderId());
			
			if(pstmt.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		return false;
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