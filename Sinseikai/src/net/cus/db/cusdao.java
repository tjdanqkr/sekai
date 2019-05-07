package net.cus.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.db.DAO;

public class cusdao implements DAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public cusdao() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
		} catch (Exception ex) {
			System.out.println("DB ���� ���� : " + ex);
			return;
		}
	}

	public List getList(cusbean bean) {

		List list = new ArrayList();
		try {
			pstmt = con.prepareStatement("select * from cusboard where name=?");
			pstmt.setString(1, bean.getName());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				bean.setTitle(rs.getString("title"));
				bean.setCon(rs.getString("con"));
				list.add(bean);

			}
			return list;
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
		return null;

	}

	public cusbean Detail(cusbean bean) {

		
		try {
			pstmt = con.prepareStatement("select * from cusboard where title=?");
			pstmt.setString(1, bean.getTitle());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				bean.setTitle(rs.getString("title"));
				bean.setCon(rs.getString("con"));
				

			}
			return bean;
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
		return null;

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
