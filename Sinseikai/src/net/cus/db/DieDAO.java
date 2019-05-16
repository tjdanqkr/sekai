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
		
		String sql="insert into diedie values(?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getEmail());
			pstmt.setString(2, bean.getProduct());
			pstmt.setString(3, bean.getTitle());
			pstmt.setString(4, bean.getSubject());
			pstmt.setString(5, bean.getPhone());
			pstmt.setString(6, bean.getReple());
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

	}public List<DieBean> getList(DieBean bean) {

		List<DieBean> list = new ArrayList<DieBean>();
		try {
			pstmt = con.prepareStatement("select * from diedie where email=?");
			pstmt.setString(1, bean.getEmail());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DieBean bean1= new DieBean();
				bean1.setTitle(rs.getString("title"));
				bean1.setEmail(rs.getString("email"));
				bean1.setPhone(rs.getString("phone"));
				bean1.setProduct(rs.getString("product"));
				bean1.setSubject(rs.getString("subject"));
				list.add(bean1);

			}
			return list;
		} catch (Exception ex) {
			System.out.println("getListCount ����: " + ex);
		}return null;
	}public DieBean Detaildie(DieBean bean) {

		
		try {
			pstmt = con.prepareStatement("select * from diedie where title=?");
			pstmt.setString(1, bean.getTitle());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				bean.setTitle(rs.getString("title"));
				bean.setEmail(rs.getString("email"));
				bean.setPhone(rs.getString("phone"));
				bean.setReple(rs.getString("reple"));
				bean.setSubject(rs.getString("subject"));
				bean.setProduct(rs.getString("product"));
			}
			return bean;
		} catch (Exception ex) {
			System.out.println("getListCount ����: " + ex);
		} return null;
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
