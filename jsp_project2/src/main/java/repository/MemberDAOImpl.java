package repository;

import java.util.List;

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

	@Override
	public List<MemberVO> selectList() {
		// TODO Auto-generated method stub
		return sql.selectList(NS+"list");
	}

	@Override
	public int update(MemberVO mvo) {
		int isOk = sql.update(NS+"modify", mvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public MemberVO selectDetail(MemberVO mvo) {
		// TODO Auto-generated method stub
		return sql.selectOne(NS+"detail", mvo);
	}

	@Override
	public int lastLogin(String id) {
		int isOk = sql.update(NS+"lastLogin", id);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int delete(String id) {
		int isOk = sql.delete(NS+"delete", id);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}
}
