package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDAO bdao;
	
	public BoardServiceImpl() {
		bdao = new BoardDAOImpl();
	}

	@Override
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		return bdao.selectList();
	}

	@Override
	public int insert(BoardVO bvo) {
		// TODO Auto-generated method stub
		return bdao.insert(bvo);
	}

	@Override
	public BoardVO detail(int bno) {
		// TODO Auto-generated method stub
		return bdao.selectOne(bno);
	}

	@Override
	public int edit(BoardVO bvo) {
		// TODO Auto-generated method stub
		return bdao.upBoard(bvo);
	}

	@Override
	public int remove(int bno) {
		// TODO Auto-generated method stub
		return bdao.delete(bno);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return bdao.selectCount();
	}

	@Override
	public List<BoardVO> getPageList(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.pageList(pgvo);
	}
	
}
