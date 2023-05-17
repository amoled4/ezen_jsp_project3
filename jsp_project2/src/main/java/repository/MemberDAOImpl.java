package repository;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DatabaseBuilder;

public class MemberDAOImpl implements MemberDAO {
	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	private SqlSession sql;
	// NameSpace = SQL이 mapper를 구분하기 위한 이름
	// NameSpace.SQL 구문이름
	private String NS = "MemberMapper.";
	
	// 생성자
	// DB 연결
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public MemberVO selectOne(MemberVO mvo) {
		// TODO Auto-generated method stub
		return sql.selectOne(NS+"login", mvo);
	}

	@Override
	public int insert(MemberVO mvo) {
		int isOk = sql.insert(NS+"join", mvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}
}
