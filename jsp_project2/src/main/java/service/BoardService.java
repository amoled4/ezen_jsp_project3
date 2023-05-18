package service;

import java.util.List;

import domain.BoardVO;

public interface BoardService {

	List<BoardVO> list();

	int insert(BoardVO bvo);

	BoardVO detail(int bno);
	
	int edit(BoardVO bvo);

	int remove(int bno);

}
