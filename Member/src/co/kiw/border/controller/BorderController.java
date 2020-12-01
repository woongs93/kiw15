package co.kiw.border.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kiw.border.command.BorderList;
import co.kiw.common.BorderCommand;

/**
 * Servlet implementation class BorderController
 */
@WebServlet("/BorderList.do")
public class BorderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 여기가 게시판 관련 처리
		request.setCharacterEncoding("utf-8"); //한글처리
		BorderCommand command = new BorderList(); //실행 명령
		String viewPage= command.action(request,  response); //실행 명령 호출
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); //보여줄 페이지
		dispatcher.forward(request,  response);
		
	}

}
