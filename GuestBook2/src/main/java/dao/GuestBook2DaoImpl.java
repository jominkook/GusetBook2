package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.GuestBook2Vo;



public class GuestBook2DaoImpl implements GuestBook2Dao  {
	private Connection getConnection() throws  SQLException {
	    Connection conn = null;
	    try {
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
	      conn = DriverManager.getConnection(dburl, "C##webdb", "1234");
	    } catch (ClassNotFoundException e) {
	      System.err.println("JDBC 드라이버 로드 실패!");
	    }
	    return conn;
	  }


	@Override
	public boolean insert(GuestBook2Vo gvo) {		
		Connection conn = null;
		 PreparedStatement pstmt = null;
		 int cnt = 0;	
		 try {
			 conn = getConnection();
			 String sql = "INSERT INTO GUESTBOOK(NO,NAME,PASSWORD,CONTENT,REG_DATE) \r\n"+
					 "VALUES(SEQ_GUESTBOOK_NO.NEXTVAL,?,?,?,sysdate)";
			 pstmt = conn.prepareStatement(sql);  
		     pstmt.setString(1, gvo.getName());
		     pstmt.setString(2, gvo.getPassword());
		     pstmt.setString(3, gvo.getContent());
		     //pstmt.setString(4, gvo.getReg_date());
		     cnt = pstmt.executeUpdate();
		     			 
		 }catch (SQLException e) {
		  System.err.println("ERROR:" + e.getMessage());
		 }
		return 1 == cnt;
	
		
		
	}

	@Override
	public List<GuestBook2Vo> getlist() {
		 Connection conn = null;
		 Statement pstmt = null;
		 ResultSet rs = null;
		 List<GuestBook2Vo> list = new ArrayList<GuestBook2Vo>();
		 try {
			 conn = getConnection();
			 pstmt =conn.createStatement();
			 String sql = "SELECT * FROM GUESTBOOK";
			 //pstmt = conn.prepareStatement(sql);
			 rs = pstmt.executeQuery(sql);
						
			 while(rs.next()) {
				 GuestBook2Vo evo = new GuestBook2Vo();
				 evo.setNo(rs.getInt("NO"));
				 evo.setName(rs.getString("NAME"));
				 evo.setPassword(rs.getString("PASSWORD"));
				 evo.setContent(rs.getString("CONTENT"));
				 evo.setReg_date(rs.getString("REG_DATE"));
				 list.add(evo);
				 
		      }
			 
		 }catch (SQLException e) {
		  System.err.println("ERROR:" + e.getMessage());
		 }
		 return list;
	}
		 
	@Override
	public boolean delete(GuestBook2Vo gvo) {
	
		Connection conn = null;
		PreparedStatement pstmt = null;	
		int cnt = 0;
		 try {
			 conn = getConnection();
			 String sql = "delete from guestbook \r\n"+ 
					 "where no = ? \r\n"+
					 "and password = ?";
	
			 pstmt = conn.prepareStatement(sql); 
			 pstmt.setInt(1, gvo.getNo());
			 pstmt.setString(2,gvo.getPassword());
		     cnt  = pstmt.executeUpdate();
		    			 
		 }catch (SQLException e) {
		  System.err.println("ERROR:" + e.getMessage());
		 }
		 return cnt == 1;
	
	}
}
