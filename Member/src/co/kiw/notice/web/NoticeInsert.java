package co.kiw.notice.web;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import co.kiw.notice.dao.NoticeDao;
import co.kiw.notice.vo.NoticeVo;

/**
 * Servlet implementation class NoticeInsert
 */
@WebServlet("/NoticeInsert.do")
public class NoticeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "filefolder";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		NoticeDao dao= new NoticeDao();
		NoticeVo vo = new NoticeVo();
		
		HttpSession session= request.getSession();
		vo.setNoticeWriter((String) session.getAttribute("name"));
		vo.setNoticeTitle(request.getParameter("title"));
		vo.setNoticeContent(request.getParameter("content"));
		
		String applicationPath=request.getServletContext().getRealPath("/");
		String uploadFilePath = applicationPath + UPLOAD_DIR;
		String fileName= null;
		
        //Get all the parts from request and write it to the file on server
        for (Part part : request.getParts()) {
        	
        	String contentDisp=part.getHeader("content-disposition");
        	String[] tokens=contentDisp.split(";");
        	for(String str: tokens) {
        		if(str.trim().startsWith("filename")) {
        			fileName= str.substring(str.indexOf("=")+2, str.length()-1);
        		}      		
            }
           
        }
        
        vo.setNoticeWriter((String) session.getAttribute("name"));
        vo.setNoticeTitle(request.getParameter("title"));
        vo.setNoticeContent(request.getParameter("content"));
        vo.setNoticeAttach(fileName);
        int n=dao.insert(vo);
        
      if(n !=0) {
    	  response.sendRedirect("/Member/NoticeList.do");
      } else {
    	  //등록 실패 페이지로 보냄
      }
        //이곳에 돌려줄 페이지 작성
	}
		




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	  private String getFileName(Part part) {
		  String contentDisp = part.getHeader("content-disposition");
		  System.out.println(" LOG :: content-disposition 헤더 :: = "+contentDisp);
		  String[] tokens = contentDisp.split(";");
		  for (String token : tokens) {
			  if (token.trim().startsWith("filename")) {
				  System.out.println(" LOG :: 파일 이름 :: " + token);
				  return token.substring(token.indexOf("=") + 2, token.length()-1);
			  }
	      }
		  return "";
	  }
}


