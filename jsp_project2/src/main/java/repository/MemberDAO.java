package repository;

import java.util.List;

import domain.MemberVO;

public interface MemberDAO {

	MemberVO selectOne(MemberVO mvo);

	int insert(MemberVO mvo);

	List<MemberVO> selectList();

	MemberVO selectDetail(MemberVO mvo);

	int update(MemberVO mvo);

	int lastLogin(String id);

	int delete(String id);

}
