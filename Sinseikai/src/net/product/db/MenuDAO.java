package net.product.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.db.DAO;

public class MenuDAO implements DAO{
	Connection con;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;

	public MenuDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
		}catch(Exception e) {
			System.out.println("Failed connect DB: " + e);
			return;
		}
	}
	
	// Get category menu.
	public List<MenuBean> getMenu() {
		List<MenuBean> beans = new ArrayList<MenuBean>();
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("select * from menu");
			
			while(rs.next()) {
				MenuBean bean = new MenuBean();
				
				bean.setMajorName(rs.getString("majorname"));
				bean.setMinorName(rs.getString("minorname"));
				bean.setCategoryName(rs.getString("categoryname"));
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
	
	// Insert category menu.
	public Boolean insertMenu(MenuBean bean) {
		try {
			pstmt = con.prepareStatement("insert into menu values(?, ?, ?, ?)");
			
			pstmt.setString(1, bean.getMajorName());
			pstmt.setString(2, bean.getMinorName());
			pstmt.setString(3, bean.getCategoryName());
			pstmt.setInt(4, bean.getCategoryCode());
			
			if(pstmt.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		return false;
	}
	
	// Delete category menu.
	public Boolean deleteMenu(MenuBean bean) {
		try {
			pstmt = con.prepareStatement("delete from menu where categorycode=?");
			
			pstmt.setInt(1, bean.getCategoryCode());
			
			if(pstmt.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		return false;
	}
	
	@Override
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
