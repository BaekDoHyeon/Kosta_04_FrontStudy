package spring.service.user;

import java.util.List;

import spring.service.domain.Member;

public interface MemberDAO {
	int registerMember(Member member) throws Exception;
	int updateMember(Member member) throws Exception;
	int deleteMember(String id) throws Exception;
	
	List<Member> showAllMember() throws Exception;
	List<Member> getMember(Member member) throws Exception;
	
	boolean idExist(String id) throws Exception;
	Member login(Member member) throws Exception;
}
