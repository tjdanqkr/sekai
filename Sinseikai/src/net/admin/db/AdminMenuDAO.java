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

public class AdminMenuDAO implements DAO{ 
	Connection con;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	public AdminMenuDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
		}catch(Exception e) {
			System.out.println("Failed connect DB: " + e);
			return;
		}
	}
	
	// Get admin menu.
	public List<AdminMenuBean> getAdminMenu() {
		List<AdminMenuBean> beans = new ArrayList<AdminMenuBean>();
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("select * from adminmenu");
			
			while(rs.next()) {
				AdminMenuBean bean = new AdminMenuBean();

				bean.setMajorName(rs.getString("majorName"));
				bean.setName(rs.getString("name"));
				bean.setUrl(rs.getString("url"));
				
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