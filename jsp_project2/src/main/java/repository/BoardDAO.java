package repository;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardDAO {

	List<BoardVO> selectList();

	int insert(BoardVO bvo);

	BoardVO selectOne(int bno);

	int upBoard(BoardVO bvo);

	int delete(int bno);

	int selectCount(PagingVO pgvo);

	List<BoardVO> pageList(PagingVO pgvo);

}
