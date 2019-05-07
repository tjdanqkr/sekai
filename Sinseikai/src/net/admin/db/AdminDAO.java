package net.admin.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.db.DAO;
import net.admin.db.*;

public class AdminDAO implements DAO{
	Connection con;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	public AdminDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
		} catch (Exception ex) {
			System.out.println("DB ���� ���� : " + ex);
			return;
		}
	}

	public boolean Adminlogin(AdminBean member){
		int num =0;
		String sql="";
		
		try{
			 sql = "select*from admin";
		      pstmt = con.prepareStatement("select*from admin");
		      rs = pstmt.executeQuery();
		      if(rs.next()) {
		         String id1 = rs.getString("id");
		         String pw1 = rs.getString("pw");
		         if (id1.equals(member.getId()) && pw1.equals(member.getPw())) {
		            return true;
		         }
		      }else {System.out.println("ddddd");}
			
	}catch(Exception ex){
		System.out.println("boardInsert ���� : "+ex);
	}finally{
		if(rs!=null) try{rs.close();}catch(SQLException ex){}
		if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
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
