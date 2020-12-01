package co.kiw.border.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kiw.border.dao.BorderDao;
import co.kiw.border.vo.BorderVo;

/**
 * Servlet implementation class BorderInput
 */
@WebServlet("/BorderInput.do")
public class BorderInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorderInput() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BorderDao dao = new BorderDao();
		BorderVo vo = new BorderVo();
		vo.setBorderWriter(request.getParameter("writer"));
		vo.setBorderDate(Date.valueOf(request.getParameter("date")));
		vo.setBorderTitle(request.getParameter("title"));
		vo.setBorderContent(request.getParameter("content"));
		
		String viewPage;
		int n = dao.insert(vo);
		if(n!=0) {
			response.sendRedirect("/Member/BorderList.do");
			//어노테이션 기반에서 서블릿 호출할 때는 response 객체 이용한다.
			
		} else {
			String msg="데이터베이스에 정상적으로 입력하지 못했습니다.";
			request.setAttribute("msg", msg);
			viewPage="jsp/border/inputError.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
		
	}
				

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
