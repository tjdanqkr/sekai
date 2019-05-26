package net.member.db;

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
import net.member.action.naver;

public class MemberDAO implements DAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	Statement stmt;
	public MemberDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
		} catch (Exception ex) {
			System.out.println("DB ���� ���� : " + ex);
			return;
		}
	}


	public MemberBean kensaku(MemberBean member) {
		try {
			pstmt = con.prepareStatement("select * from member where email=?");
			pstmt.setString(1, member.getEmail());
			
			rs = pstmt.executeQuery();
			System.out.println("e: " + member.getEmail());
			if(rs.next()) {
				System.out.println("a : " + rs.getString("name"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setPw(rs.getString("pw"));
				member.setNum1(rs.getInt("num1"));
				member.setPhone(rs.getString("phone"));
				member.setAge(rs.getInt("age"));
				member.setAddress(rs.getString("Address"));
				
			}	return member;		
		} catch (Exception ex) {
			System.out.println("boardInsert kensaku: " + ex);
		} 
		return null;
	}
	
	
	
	
	public boolean memberInsert(MemberBean member) {
		String sql = "";

		int result = 0;
		System.out.println(member.getAddress() + "ㅇㅇ");
		try {
			System.out.println(member.getAddress() + "ㅇㅇ");

			sql = "insert into member values (?,?,?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getPw());
			pstmt.setInt(4, member.getNum1());
			pstmt.setInt(5, member.getAge());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getAddress());
			System.out.println(member.getAddress());
			pstmt.executeUpdate();

			result = result + 1;
			if (result == 0) {

				return false;
			}

			return true;
		} catch (Exception ex) {
			System.out.println("boardInsert ���� : " + ex);
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

	public boolean idCheck(MemberBean member) {
		boolean rst = false;
		String id = member.getEmail();
		try {

			String sql = "select * from member where email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				rst = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rst;
	}

	public boolean memberlogin(MemberBean member) {
		int num = 0;
		String sql = "";

		int result = 0;
		try {
			sql = "select email,pw,name from member";

			int f = 0;
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String id1 = rs.getString(1);
				String pw1 = rs.getString(2);
				if (id1.equals(member.getEmail()) && pw1.equals(member.getPw())) {
					f = 1;
					result = +1;
					member.setName(rs.getString("name"));
					return true;
				}
			}

			if (result == 0) {

				return false;
			}

		} catch (Exception ex) {
			System.out.println("boardInsert ���� : " + ex);
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
	}public boolean memberupdate(MemberBean member) {
		int num = 0;
		String sql = "";

		int result = 0;
		try {
			sql = "update member set phone =? where email=?";
			
			int f = 0;
			System.out.println("sql삽입");
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, member.getPhone());
			stmt.setString(2, member.getEmail());
			stmt.executeUpdate();
			return true;

			

		} catch (Exception ex) {
			System.out.println("boardInsert ���� : " + ex);
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
	}public boolean memberupdateN(NaverBean member) {
		int num = 0;
		String sql = "";

		int result = 0;
		try {
			sql = "update naver set phone =? where id=?";
			
			int f = 0;
			System.out.println("sql삽입");
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, member.getPhone());
			stmt.setString(2, member.getId());
			stmt.executeUpdate();
			return true;

			

		} catch (Exception ex) {
			System.out.println("boardInsert ���� : " + ex);
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

	public boolean naverInsert(NaverBean member) {
		int num = 0;
		String sql = "";

		int result = 0;

		try {
			System.out.println("인설트");
			sql = "insert into naver values (?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getAge());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, "아직 없어요 ㅠ");
			pstmt.executeUpdate();

			result = result + 1;
			if (result == 0) {

				return false;
			}

			return true;
		} catch (Exception ex) {
			System.out.println("boardInsert ���� : " + ex);
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

	public boolean naverCheck(NaverBean member) {
		int num = 0;
		String sql = "";

		int result = 0;

		try {

			sql = "select*from naver where id=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, member.getId());
			rs = pstmt.executeQuery();
			if (rs.next()) {

				result = result + 1;
			}
			if (result == 0) {

				return false;
			}

			return true;
		} catch (Exception ex) {
			System.out.println("boardInsert ���� : " + ex);
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

	public boolean dieinf(MemberBean member) {
		int num = 0;
		String sql = "";

		int result = 0;
		try {
			sql = "select email,name,phone from member where email=?";
			System.out.println(member.getEmail());
			int f = 0;
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, member.getEmail());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				f=1;
			}
		
			if (f == 0) {
				return false;
			}
			return true;
		} catch (Exception ex) {
			System.out.println("boardInsert ���� : " + ex);
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
	public boolean dieinfN(NaverBean member) {
		int num = 0;
		String sql = "";

		int result = 0;
		try {
			sql = "select email,name,phone from naver where id=?";

			int f = 0;
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, member.getId());
			
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("email")+"dda");
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				result=1;
				
			}

			if (result == 0) {

				return false;
			}
			return true;
		} catch (Exception ex) {
			System.out.println("boardInsert ���� : " + ex);
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
	}public List<MemberBean> Memberlookup() {
		String sql = "";
		
		int result = 0;
		
		try {
			

			sql = "select*from member";
			stmt = con.createStatement();
			 rs = stmt.executeQuery(sql);
			 List<MemberBean> list = new ArrayList<MemberBean>();
			 while(rs.next()) {
				 MemberBean member = new MemberBean();
				 member.setEmail(rs.getString("email"));
				 member.setPw(rs.getString("pw"));
				 member.setName(rs.getString("name"));
				 member.setNum1(rs.getInt("num1"));
				 member.setAge(rs.getInt("age"));
				 member.setPhone(rs.getString("phone"));
				 member.setAddress(rs.getString("address"));
				 list.add(member);
				 result = result + 1;
			 }
			
			if (result == 0) {

				return null;
			}

			return list;
		} catch (Exception ex) {
			System.out.println("멤버가 없나봐 : " + ex);
		}
		return null;
	}public List<NaverBean> Naberlookup() {
		String sql = "";
		
		int result = 0;
		
		try {
			

			sql = "select*from naver";
			stmt = con.createStatement();
			 rs = stmt.executeQuery(sql);
			 
			 List<NaverBean> list = new ArrayList<NaverBean>();
			 while(rs.next()) {
				 
				 NaverBean member = new NaverBean();
				 member.setEmail(rs.getString("email"));
				 member.setId(rs.getString("id"));
				 member.setName(rs.getString("name"));
				 member.setAge(rs.getString("age"));
				 member.setPhone(rs.getString("phone"));
				 list.add(member);
				 result = result + 1;
			 }
			
			if (result == 0) {

				return null;
			}

			return list;
		} catch (Exception ex) {
			System.out.println("네이버 멤버가 없나봐 : " + ex);
		}
		return null;
	}

	@Override
	public void close() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
