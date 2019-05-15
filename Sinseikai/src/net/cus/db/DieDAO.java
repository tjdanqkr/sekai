package net.cus.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.db.DAO;

public class DieDAO implements DAO{
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	public DieDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
		} catch (Exception ex) {
			System.out.println("DB ���� ���� : " + ex);
			return;
		}
	}public boolean DieInsert(DieBean bean) {

		
		try {
			pstmt = con.prepareStatement("insert diedie into values('?','?','?','?','?')");
			pstmt.setString(1, bean.getEmail());
			pstmt.setString(2, bean.getProduct());
			pstmt.setString(3, bean.getTitle());
			pstmt.setString(4, bean.getSubject());
			pstmt.setString(5, bean.getPhone());
			pstmt.executeUpdate();

			
			return true;
		} catch (Exception ex) {
			System.out.println("getListCount ����: " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}
		return false;

	}

	
	@Override
	public void close() {
		// TODO Auto-generated method stub
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

}
