package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import orm.DatabaseBuilder;

public class CommentDAOImpl implements CommentDAO {
	private static final Logger log = LoggerFactory.getLogger(CommentDAOImpl.class);
	private SqlSession sql;
	// NameSpace = SQL이 mapper를 구분하기 위한 이름
	// NameSpace.SQL 구문이름
	private String NS = "CommentMapper.";
	private int isOk;
	
	public CommentDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(CommentVO cvo) {
		log.info(">>> comment post > DAO in");
		isOk = sql.insert(NS+"post", cvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public List<CommentVO> getList(int bno) {
		log.info(">>> comment list > DAO in");
		return sql.selectList(NS+"list",bno);
	}

	@Override
	public int delete(int cno) {
		log.info(">>> comment remove > DAO in");
		isOk = sql.delete(NS+"delete", cno);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int update(CommentVO cvo) {
		log.info(">>> comment modify > DAO in");
		isOk = sql.update(NS+"update", cvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

}
