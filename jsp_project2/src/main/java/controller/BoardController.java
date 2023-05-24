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

import domain.BoardVO;
import domain.MemberVO;
import domain.PagingVO;
import handler.PagingHandler;
import service.BoardService;
import service.BoardServiceImpl;


@WebServlet("/brd/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	private RequestDispatcher rdp; // 웹의 목적지 주소로 객체를 전달해주는 객체
	private BoardService bsv; // interface 구현체
	private int isOk; // DB의 insert, update, delete의 결과를 받는 변수
	private String destPage; // 목적지 주소를 저장해주는 변수
	
	private int bno;
	private String title;
	private String writer;
	private String regdate;
	private String content;
	private int readcount;
	private BoardVO bvo;
	private PagingVO pgvo;
	private int pageNo;  
	private int qty; 
	private String type;
	private String keyword;
	
	
	private HttpSession ses;
    
    public BoardController() {
    	bsv = new BoardServiceImpl();
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
		case "list":
			List<BoardVO> list = new ArrayList<BoardVO>();
			list = bsv.list();
			request.setAttribute("list", list);
			destPage="/board/list.jsp";
			break;
			
		case "page":
			try {
				pageNo = 1;
				qty = 10;
				type ="";
				keyword= "";
				if(request.getParameter("type") != null) {
					type = request.getParameter("type");
					keyword = request.getParameter("keyword");
					log.info(">>>type >"+type+" >>> keyword > "+keyword);	
				}
				if(request.getParameter("pageNo") !=null) {
					pageNo = Integer.parseInt(request.getParameter("pageNo"));
					qty = Integer.parseInt(request.getParameter("qty"));
				}
				pgvo = new PagingVO(pageNo, qty);
				pgvo.setType(type);
				pgvo.setKeyword(keyword);
				log.info(">>> pgvo > "+pgvo);
				// 전체 페이지 개수
				int totalCount = bsv.getTotal(pgvo);   // 전체 페이지 개수 DB에 요청
				log.info("전체 페이지 개수 : "+totalCount);
				// limit를 이용한 select List를 호출 (startPage, qty)
				// 한 페이지에 나와야 하는 리스트
				List<BoardVO> list1 = bsv.getPageList(pgvo);
				log.info(">>> list > "+list1.size());
				PagingHandler ph = new PagingHandler(pgvo, totalCount);
				request.setAttribute("pgh", ph);
				request.setAttribute("list", list1);
				log.info("pageList 성공");
				destPage = "/board/list.jsp";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
			
		case "register":
			destPage="/board/register.jsp";
			break;
			
		case "insert":
			ses = request.getSession();
			title = request.getParameter("title");
			writer = ((MemberVO)ses.getAttribute("ses")).getId();
			content = request.getParameter("content");
			bvo = new BoardVO(title, writer, content);
			
			isOk = bsv.insert(bvo);
			log.info(">>> 글작성 > "+(isOk>0?"성공":"실패"));
			destPage = "/brd/page";
			break;
			
		case "detail":
			bno = Integer.parseInt(request.getParameter("bno"));
			bvo = bsv.detail(bno);
			request.setAttribute("bvo", bvo);
			
			destPage="/board/detail.jsp";
			break;
			
		case "modify":
			bno = Integer.parseInt(request.getParameter("bno"));
			bvo = bsv.detail(bno);
			request.setAttribute("bvo", bvo);
			destPage="/board/modify.jsp";
			break;
			
		case "edit":
			bno = Integer.parseInt(request.getParameter("bno"));
			title = request.getParameter("title");
			content = request.getParameter("content");
			bvo = new BoardVO(bno, title, content);
			
			isOk = bsv.edit(bvo);
			log.info(">>> 글 수정 > "+(isOk>0?"성공":"실패"));
			destPage = "/brd/page";
			break;
			
		case "remove":
			bno = Integer.parseInt(request.getParameter("bno"));
			
			isOk = bsv.remove(bno);
			log.info(">>> 글 삭제 > "+(isOk>0?"성공":"실패"));
			destPage="/brd/page";
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
