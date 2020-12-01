package co.kiw.border.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.kiw.border.vo.BorderVo;
import co.kiw.common.DAO;

public class BorderDao extends DAO{
   private PreparedStatement psmt;
   private ResultSet rs;
   
   private final String SELECT_ALL = "SELECT * FROM BORDER ORDER BY 1 DESC";
   private final String SELECT_ONE = "SELECT * FROM BORDER WHERE borderID = ? ";
   private final String INSERT = "INSERT INTO BORDER(BORDERID, BORDERWRITER, BORDERTITLE, BORDERCONTENT, BORDERDATE)" + 
                          " VALUES(B_SEQ.NEXTVAL,?,?,?,?)";
   private final String HIT_UPDATE = "UPDATE BORDER" + 
                             " SET BORDERHIT = BORDERHIT+1" + 
                             " WHERE BORDERID = ?";
   private final String UPDATE= "UPDATE BORDER SET BORDERDATE=?, BORDERCONTENT=? WHERE BORDERID=?";
   
   private final String DELETE= "DELETE FROM BORDER WHERE BORDERID=?";
   
   public ArrayList<BorderVo> selectAll(){ //전체 데이터 가져오기
      ArrayList<BorderVo> list = new ArrayList<BorderVo>();
      BorderVo vo;
      try {
         psmt = conn.prepareStatement(SELECT_ALL);
         rs = psmt.executeQuery();
         while(rs.next()) {
            vo = new BorderVo();
            vo.setBorderId(rs.getInt("borderid"));
            vo.setBorderWriter(rs.getString("borderwriter"));
            vo.setBorderTitle(rs.getString("bordertitle"));
            vo.setBorderContent(rs.getString("bordercontent"));
            vo.setBorderDate(rs.getDate("borderdate"));
            vo.setBorderHit(rs.getInt("borderhit"));
            list.add(vo);
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         close();
      }
      
      return list;
   }
   
   public BorderVo selectOne(BorderVo vo) {//한 레코드 검색
      try {
         psmt = conn.prepareStatement(SELECT_ONE);
         psmt.setInt(1, vo.getBorderId());
         rs = psmt.executeQuery();
         if(rs.next()) {
            psmt=conn.prepareStatement(HIT_UPDATE);
            psmt.setInt(1, vo.getBorderId());
            psmt.execute();
            vo.setBorderId(rs.getInt("borderid"));
            vo.setBorderWriter(rs.getString("borderwriter"));
            vo.setBorderTitle(rs.getString("bordertitle"));
            vo.setBorderContent(rs.getString("bordercontent"));
            vo.setBorderDate(rs.getDate("borderdate"));
            vo.setBorderHit(rs.getInt("borderhit"));
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         close();
      }
      
      return vo;
   }
   
   public BorderVo selectSearcher(BorderVo vo) {//한 레코드 검색
	      try {
	         psmt = conn.prepareStatement(SELECT_ONE);
	         psmt.setInt(1, vo.getBorderId());
	         rs = psmt.executeQuery();
	         if(rs.next()) {
	            psmt=conn.prepareStatement(HIT_UPDATE);
	            psmt.setInt(1, vo.getBorderId());
	            psmt.execute();
	            vo.setBorderId(rs.getInt("borderid"));
	            vo.setBorderWriter(rs.getString("borderwriter"));
	            vo.setBorderTitle(rs.getString("bordertitle"));
	            vo.setBorderContent(rs.getString("bordercontent"));
	            vo.setBorderDate(rs.getDate("borderdate"));
	            vo.setBorderHit(rs.getInt("borderhit"));
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         close();
	      }
	      
	      return vo;
	   }
   
   public int insert(BorderVo vo) {//게시글 입력
      int n = 0;
      try {
         psmt = conn.prepareStatement(INSERT);
         psmt.setString(1, vo.getBorderWriter());
         psmt.setString(2, vo.getBorderTitle());
         psmt.setString(3, vo.getBorderContent());
         psmt.setDate(4, vo.getBorderDate());
         n = psmt.executeUpdate();
      } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
       } finally {
          close();
       }  
      
      return n;
   }
   
   public int delete(BorderVo vo) {//게시글 삭제
      int n = 0;
      
 
      try {
    	  psmt=conn.prepareStatement(UPDATE);
    	  psmt.setInt(1, vo.getBorderId());
    	  n=psmt.executeUpdate();
       } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
       } finally {
          close();
       }  
      
      return n;
   }
   
   
   public int update(BorderVo vo) {//게시글 수정
      int n = 0;
      try {
    	  psmt=conn.prepareStatement(UPDATE);
    	  psmt.setDate(1, vo.getBorderDate());
    	  psmt.setNString(2,  vo.getBorderContent());
    	  psmt.setInt(3, vo.getBorderId());
    	  n=psmt.executeUpdate();
       } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
       } finally {
          close();
       }  
      
      return n;
   }

   private void close() {
      // TODO Auto-generated method stub
      try {
         if(rs != null) rs.close();
         if(psmt != null) psmt.close();
         if(conn != null) conn.close();
      }catch(SQLException e) {
         e.printStackTrace();
      }
   }
}