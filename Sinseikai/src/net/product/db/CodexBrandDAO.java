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

public class CodexBrandDAO implements DAO{ 
	Connection con;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	public CodexBrandDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
		}catch(Exception e) {
			System.out.println("Failed connect DB: " + e);
			return;
		}
	}
	public List<CodexBrandBean> brandpull(CodexBrandBean bean) throws SQLException {
		List<CodexBrandBean> list = new ArrayList<CodexBrandBean>();
		
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from codexBrand ");
		while(rs.next()) {
			CodexBrandBean bean1 = new CodexBrandBean();
			bean1.setBrandName(rs.getString("brandName"));
			
			list.add(bean1);
		}
		return list;
	}
		
	// Get brandcode as brandname in bean.
	public CodexBrandBean getBrandcodeAsBrandname(ProductBean productBean) {
		CodexBrandBean codexBrandBean = new CodexBrandBean();
		try {
			pstmt = con.prepareStatement("select * from codexbrand where brandname=?");
			pstmt.setString(1, productBean.getBrandName());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				codexBrandBean.setBrandName(rs.getString("brandname"));
				codexBrandBean.setBrandCode(rs.getInt("brandcode"));
			}
			
			return codexBrandBean;
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