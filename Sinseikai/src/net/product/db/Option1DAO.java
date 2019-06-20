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

import javax.naming.Context;
import javax.naming.InitialContext;

public class Option1DAO implements DAO{ 
	Connection con;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	public Option1DAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
		}catch(Exception e) {
			System.out.println("Failed connect DB: " + e);
			return;
		}
	}
	
	// Get options as productNumber in productBean.
	public List<Option1Bean> getOptionsAsProductnumber(ProductBean productBean) {
		List<Option1Bean> beans = null;
		try {
			pstmt = con.prepareStatement("select * from option1 where productnumber=? "
					+ "order by majornumber, paminornumber, minornumber"); // Sort by major, paminor, minor number.
			pstmt.setInt(1, productBean.getProductNumber());
			
			rs = pstmt.executeQuery();
			
			beans = new ArrayList<Option1Bean>();
			while(rs.next()) { // Put the options.
				Option1Bean bean = new Option1Bean();
				
				bean.setProductNumber(rs.getInt("productnumber"));
				bean.setMajorName(rs.getString("majorname"));
				bean.setMajorNumber(rs.getInt("majornumber"));
				bean.setMinorNumber(rs.getInt("minornumber"));
				bean.setMinorName(rs.getString("minorname"));
				bean.setMinorImg(rs.getString("minorimg"));
				bean.setMinorPrice(rs.getInt("minorprice"));
				bean.setMinorStock(rs.getInt("minorstock"));
				bean.setPaMajorNumber(rs.getInt("pamajornumber"));
				bean.setPaMinorNumber(rs.getInt("paminornumber"));
				
				beans.add(bean);
			}
			
			return beans;
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		return null;
	}
	
	/*
	 * Insert product option.
	 */
	public boolean insertOption(Option1Bean bean) {
		try {
			pstmt = con.prepareStatement("insert into option1 values(?, ?, ?, ?, ?, "
					+ "?, ?, ?, ?, ?)"); // Sort by major, paminor, minor number.
			pstmt.setInt(1, bean.getProductNumber());
			pstmt.setString(2, bean.getMajorName());
			pstmt.setInt(3, bean.getMajorNumber());
			pstmt.setInt(4, bean.getMinorNumber());
			pstmt.setString(5, bean.getMinorName());
			pstmt.setString(6, bean.getMinorImg());
			pstmt.setInt(7, bean.getMinorPrice());
			pstmt.setInt(8, bean.getMinorStock());
			pstmt.setInt(9, bean.getPaMajorNumber());
			pstmt.setInt(10, bean.getPaMinorNumber());
			
			if(pstmt.executeUpdate() == 1) {
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