package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;


@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	private RequestDispatcher rdp; // 웹의 목적지 주소로 객체를 전달해주는 객체
	private MemberService msv; // interface 구현체
	private int isOk; // DB의 insert, update, delete의 결과를 받는 변수
	private String destPage; // 목적지 주소를 저장해주는 변수
   
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String email;
	private String regdate;
	private String last_login;
	private int auth;
	private MemberVO mvo;
	
	HttpSession ses;
	
    public MemberController() {
        msv = new MemberServiceImpl();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String uri = request.getRequestURI();
		log.info(">>> uri : " + uri);
		// /mem/join : 요청에 대한 path만 남기기
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info(">>> path : " + path);
		
		switch (path) {
		case "login":
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			mvo = new MemberVO(id, pw);
			MemberVO loginMvo = msv.login(mvo);
			if(loginMvo != null) {
				ses = request.getSession();
				ses.setAttribute("ses", loginMvo);
			} else {
				request.setAttribute("msg_login", 0);
			}
			destPage="/";
			break;
			
		case "sign":
			destPage="/member/join.jsp";
			break;
			
		case "join":
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			name = request.getParameter("name");
			phone = request.getParameter("phone");
			email = request.getParameter("email");
			mvo = new MemberVO(id, pw, name, phone, email);
			
			isOk = msv.join(mvo);
			log.info(">>> 회원가입 > "+ (isOk>0 ? "성공":"실패"));
			request.setAttribute("msg_join", 0);
			destPage="/";
			break;
			
		case "list":
			List<MemberVO> list = new ArrayList<MemberVO>();
			list = msv.list();
			request.setAttribute("list", list);
			destPage="/member/list.jsp";
			break;
			
		case "detail":
			id = request.getParameter("id");
			mvo = new MemberVO(id);
			request.setAttribute("mvo", msv.detail(mvo));
			destPage="/member/detail.jsp";
			break;
			
		case "modify":
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			phone = request.getParameter("phone");
			email = request.getParameter("email");
			if(request.getParameter("auth") != null) {
				auth = Integer.parseInt(request.getParameter("auth"));
			}
			mvo = new MemberVO(id, pw, phone, email, auth);
			
			isOk = msv.modify(mvo);
			log.info(">>> 회원정보 수정 > "+ (isOk>0 ? "성공":"실패"));
			request.setAttribute("msg_modify", 0);
			destPage ="/";
			break;
			
		case "logout":
			ses = request.getSession();
			mvo = (MemberVO)ses.getAttribute("ses");
			id = mvo.getId();
			isOk = msv.lastLogin(id);
			ses.invalidate();
			destPage = "/";
			break;
			
		case "remove":
			request.setAttribute("msg_remove", 0);
			id = request.getParameter("id");
			isOk = msv.remove(id);
			log.info(">>> 회원탈퇴 > "+ (isOk>0? "성공":"실패"));
			
			ses = request.getSession();
			mvo = (MemberVO)ses.getAttribute("ses");
			if(isOk>0 && id.equals(mvo.getId())) {
				ses.invalidate();
			}
			destPage="/";
			break;
		}
		
		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
