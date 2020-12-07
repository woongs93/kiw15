package co.kiw.member.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.kiw.member.dao.MemberDao;
import co.kiw.member.vo.MemberVo;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO �뿬湲곗꽌 紐⑤뱺寃껋쓣 泥섎━�븳�떎.
		request.setCharacterEncoding("utf-8");
		MemberVo vo= new MemberVo();
		MemberDao dao= new MemberDao();
		HttpSession session = request.getSession(false); //�꽭�뀡媛앹껜瑜� 媛��졇�삩�떎.
		
		vo.setMemberId(request.getParameter("mid"));
		vo.setPassword(request.getParameter("password"));
		
		vo= dao.memberLoginCheck(vo);
		System.out.println(vo.getMemberAuth());
		if(vo.getMemberAuth() != null) {
			
			session.setAttribute("id", vo.getMemberId());
			session.setAttribute("auth", vo.getMemberAuth());
			session.setAttribute("name", vo.getMemberName());
		}	
		
		request.setAttribute("vo", vo);	
		String viewPage= "jsp/member/loginResult.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
			
	}
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
