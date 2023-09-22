package memberone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class StudentDAO {
	
	private static StudentDAO instance = null;
	
	private StudentDAO() { }
	public static StudentDAO getInstance() {
		if(instance == null) {
			synchronized(StudentDAO.class) {
				instance = new StudentDAO();
			}
		}
		return instance;
	}
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/myOracle");
			conn = ds.getConnection();
		} catch(Exception e) {
			System.err.println("Connection 생성 실패");
		}
		return conn;
	}
	
	public boolean idCheck(String id) {
		boolean result = true;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from student where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				result = false;		//사용 가능
			}
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch(SQLException sqle1) { }
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(SQLException sqle2) { }
			}
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException sqle3) { }
			}
		}
		return result;
	}
	
	public Vector<ZipCodeVO> zipcodeRead(String dong) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<ZipCodeVO> vecList = new Vector<ZipCodeVO>();
		try {
			conn = getConnection();
			String strQuery = "Select * from zipcode where dong like '" + dong + "%'";
			pstmt = conn.prepareStatement(strQuery);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ZipCodeVO tempZipcode = new ZipCodeVO();
				tempZipcode.setZipcode(rs.getString("zipcode"));
				tempZipcode.setSido(rs.getString("sido"));
				tempZipcode.setGugun(rs.getString("gugun"));
				tempZipcode.setDong(rs.getString("dong"));
				tempZipcode.setRi(rs.getString("ri"));
				tempZipcode.setBunji(rs.getString("bunji"));
				vecList.addElement(tempZipcode);
			}
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException sqle1) { }
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException sqle1) { }
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException sqle1) { }
			}
		}
		return vecList;
	}
	
	/*
	 * 실제 데이터베이스에 회원데이터를 넣는 메소드
	 */
	public boolean memberInsert(StudentVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;		// registration 실패
		try {
			conn = getConnection();
			String strQuery = "insert into student values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(strQuery);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone1());
			pstmt.setString(5, vo.getPhone2());
			pstmt.setString(6, vo.getPhone3());
			pstmt.setString(7, vo.getEmail());
			pstmt.setString(8, vo.getZipcode());
			pstmt.setString(9, vo.getAddress1());
			pstmt.setString(10, vo.getAddress2());
			int count = pstmt.executeUpdate();
			
			if(count>0) {
				flag = true;	//registration 성공
			} 
		} catch(Exception ex) {
			System.out.println("Exception" + ex);
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch(SQLException sqle1) { }
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(SQLException sqle2) { }
			}
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException sql3) { }
			}
		}//end finally
		return flag;
		
	}//end memberInsert
	
	public int loginCheck(String id, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check = -1;						//아이디 없음
		try {
			conn = getConnection();
			String strQuery = "select pass from student where id = ?";
			pstmt = conn.prepareStatement(strQuery);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbPass = rs.getString("pass");
				if(pass.equals(dbPass)) {
					check = 1;				//로그인 성공
				} else {
					check = 0;				//비밀번호 오류
				}
			}
		} catch(Exception ex) {
			System.out.println("Exception" + ex);
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException sqle1) { }
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(SQLException sqle2) { }
			}
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException sqle2) { }
			}
		}
		return check;
	}
	
	/*
	 * StudentDAO에 아이디를 가지고 회원정보를 얻어오는 메소드
	 */
	public StudentVO getMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentVO vo = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from student where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new StudentVO();
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setPhone1(rs.getString("phone1"));
				vo.setPhone2(rs.getString("phone2"));
				vo.setPhone3(rs.getString("phone3"));
				vo.setEmail(rs.getString("email"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddress1(rs.getString("address1"));
				vo.setAddress2(rs.getString("address2"));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch(SQLException sqle1) { }
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(SQLException sqle2) { }
			}
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException sqle3) { }
			}
		}
		return vo;
	}
	
	public void updateMember(StudentVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("update student set pass = ?, phone1 = ?, phone2 = ?, phone3 = ?, email = ?, zipcode = ?, address1 = ?, address2 = ? where id = ?");
			pstmt.setString(1, vo.getPass());
			pstmt.setString(2, vo.getPhone1());
			pstmt.setString(3, vo.getPhone2());
			pstmt.setString(4, vo.getPhone3());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getZipcode());
			pstmt.setString(7, vo.getAddress1());
			pstmt.setString(8, vo.getAddress2());
			pstmt.setString(9, vo.getId());
			pstmt.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(SQLException sqle1) { }
			}
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException sqle2) { }
			}
		}
	}
	
	public int deleteMember(String id, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbPass = "";
		int result = -1;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select pass from student where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dbPass = rs.getString("pass");
				if(dbPass.equals(pass)) {
					pstmt = conn.prepareStatement("delete from student where id = ?");
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					result = 1;
				} else {
					result = 0;
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch(SQLException sqle1) { }
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(SQLException sqle2) { }
			}
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException sqle3) { }
			}
		}
		return result;
	}
	
	
}
