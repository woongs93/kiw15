package co.kiw.border.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kiw.member.dao.MemberDao;
import co.kiw.member.vo.MemberVo;

/**
 * Servlet implementation class BorderRegister
 */
@WebServlet("/Register.do")
public class BorderRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorderRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberVo vo= new MemberVo();
		MemberDao dao= new MemberDao();
		
		
		vo.setMemberId(request.getParameter("mid"));
		vo.setMemberName(request.getParameter("mname"));
		vo.setPassword(request.getParameter("password"));
		String viewPage ="jsp/member/registergood.jsp";
		int n = dao.insert(vo);
		
		request.setAttribute("name", vo.getMemberName());
		RequestDispatcher dispatcher= request.getRequestDispatcher(viewPage);
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
