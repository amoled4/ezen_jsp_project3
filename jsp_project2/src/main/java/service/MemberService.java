package service;

import java.util.List;

import domain.MemberVO;

public interface MemberService {

	MemberVO login(MemberVO mvo);

	int join(MemberVO mvo);

	List<MemberVO> list();

	MemberVO detail(MemberVO mvo);

	int modify(MemberVO mvo);

	int lastLogin(String id);

	int remove(String id);

}
