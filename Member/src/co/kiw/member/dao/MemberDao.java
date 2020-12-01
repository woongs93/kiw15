package co.kiw.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.kiw.member.vo.MemberVo;

public class MemberDao {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user= "kiw";
	private String password= "1234";
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	//이 부분 sql 작성
	private final String MEMBERLOGIN = "SELECT * FROM MEMBER WHERE MEMBERID = ? AND PASSWORD = ?";
	private final String INSERT="INSERT INTO MEMBER VALUES(?, ?, ?, 'user', 0)";

	public MemberDao() {
		try {
			Class.forName(driver);
			conn= DriverManager.getConnection(url, user, password);
			
		} catch(ClassNotFoundException | SQLException e) {
			System.out.println("DB 연결실패 ㅠㅠ");
		}
	}
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberVo> selectAll(){
		ArrayList<MemberVo> list= new ArrayList<MemberVo>();
		
		return list;
	}
	
	public MemberVo select(MemberVo vo) {
		return vo;
	}
	
	public MemberVo memberLoginCheck(MemberVo vo) {
		try { 
			psmt = conn.prepareStatement(MEMBERLOGIN);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberAuth(rs.getString("memberauth"));
			}
		} catch(SQLException e ) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	public int insert(MemberVo vo) {
		int n=0;
		try {
			psmt= conn.prepareStatement(INSERT);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(1, vo.getMemberName());
			psmt.setString(1, vo.getPassword());
			n =psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}
	public int update(MemberVo vo) {
		int n=0;
		return n;
	}
	public int delete(MemberVo vo) {
		int n=0;
		return n;
	}
	
	
	public String idCheck(String key) {
		String checkKey = null;
		try {
			psmt=conn.prepareStatement(idCheck);
			psmt.setNString(1,  key);
			rs=psmt.executeQuery();
			if(rs.next()) {
				checkKey = rs.getNString("memberid");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally { 
			close();
		}
		return checkKey;
	}
}
