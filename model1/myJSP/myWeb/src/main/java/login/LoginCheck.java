package login;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","mytest", "mytest");
			pstmt = con.prepareStatement("select pass from login where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbPass = rs.getString("pass");
				if(dbPass.equals(pwd)) {
					HttpSession session = request.getSession();
					session.setAttribute("user", id);
				}else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			} else {
				System.out.println("아이디가 존재하지 않습니다.");
			} 
		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			try{if(rs != null)rs.close();}catch(SQLException e){}
			try{if(pstmt != null)pstmt.close();}catch(SQLException e){}
			try{if(con != null)con.close();}catch(SQLException e){}
		}
		response.sendRedirect("Login");
	} 
//		StringBuffer sql = new StringBuffer();
//		sql.append("select id, pass ");
//		sql.append("from login ");
//		sql.append("where id =? and pass = ?");
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521/XEPDB1","mytest", "mytest");
//			pstmt = con.prepareStatement(sql.toString());
//			pstmt.setString(1, id);
//			pstmt.setString(2, pwd);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()){
//				rs.getString("id");
//				rs.getString("pass");
//				if(rs.getString("id").equals(id) && rs.getString("pass").equals(pwd)) {
//					HttpSession session = request.getSession();
//					session.setAttribute("user", id);
//				}
//			}
//		}catch(SQLException e){
//			e.printStackTrace();
//		}catch(ClassNotFoundException e){
//			e.printStackTrace();
//		}finally{
//			try{if(rs != null)rs.close();}catch(SQLException e){}
//			try{if(pstmt != null)pstmt.close();}catch(SQLException e){}
//			try{if(con != null)con.close();}catch(SQLException e){}
//		}
//		response.sendRedirect("Login");
//	} 
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}