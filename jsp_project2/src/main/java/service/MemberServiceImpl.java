package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	private MemberDAO mdao;
	
	public MemberServiceImpl() {
		mdao = new MemberDAOImpl();
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		// TODO Auto-generated method stub
		return mdao.selectOne(mvo);
	}

	@Override
	public int join(MemberVO mvo) {
		// TODO Auto-generated method stub
		return mdao.insert(mvo);
	}

	@Override
	public List<MemberVO> list() {
		// TODO Auto-generated method stub
		return mdao.selectList();
	}

	@Override
	public int modify(MemberVO mvo) {
		// TODO Auto-generated method stub
		return mdao.update(mvo);
	}

	@Override
	public MemberVO detail(MemberVO mvo) {
		// TODO Auto-generated method stub
		return mdao.selectDetail(mvo);
	}

	@Override
	public int lastLogin(String id) {
		// TODO Auto-generated method stub
		return mdao.lastLogin(id);
	}

	@Override
	public int remove(String id) {
		// TODO Auto-generated method stub
		return mdao.delete(id);
	}
}
