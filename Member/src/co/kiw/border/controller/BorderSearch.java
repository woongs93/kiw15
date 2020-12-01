package co.kiw.border.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kiw.border.dao.BorderDao;
import co.kiw.border.vo.BorderVo;

/**
 * Servlet implementation class BorderSearch
 */
@WebServlet("/BorderSearch.do")
public class BorderSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorderSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO controller에 module 구현
		request.setCharacterEncoding("utf-8");
		BorderDao dao= new BorderDao();
		BorderVo vo= new BorderVo();
		
		vo.setBorderId(Integer.parseInt(request.getParameter("id")));
		vo= dao.selectSearcher(vo);
		
		request.setAttribute("vo", vo);
		String viewPage="jsp/border/borderEdit.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
