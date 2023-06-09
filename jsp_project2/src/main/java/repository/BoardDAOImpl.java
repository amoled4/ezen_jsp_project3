package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import orm.DatabaseBuilder;

public class BoardDAOImpl implements BoardDAO {
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	private SqlSession sql;
	// NameSpace = SQL이 mapper를 구분하기 위한 이름
	// NameSpace.SQL 구문이름
	private String NS = "BoardMapper.";
	private int isOk;
	
	public BoardDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public List<BoardVO> selectList() {
		// TODO Auto-generated method stub
		return sql.selectList(NS+"list");
	}

	@Override
	public int insert(BoardVO bvo) {
		isOk = sql.insert(NS+"insert", bvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public BoardVO selectOne(int bno) {
		isOk = sql.update(NS+"count", bno);
		if(isOk>0) {
			sql.commit();
		}
		// TODO Auto-generated method stub
		return sql.selectOne(NS+"detail", bno);
	}


	@Override
	public int upBoard(BoardVO bvo) {
		isOk = sql.update(NS+"upBoard", bvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int delete(int bno) {
		isOk = sql.delete(NS+"delete", bno);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int selectCount(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return sql.selectOne(NS+"totcount", pgvo);
	}

	@Override
	public List<BoardVO> pageList(PagingVO pgvo) {
		// TODO Auto-generated method stub
		//return sql.selectList(NS+"pageList", pgvo);
		return sql.selectList(NS+"selectList", pgvo);
	}
}
