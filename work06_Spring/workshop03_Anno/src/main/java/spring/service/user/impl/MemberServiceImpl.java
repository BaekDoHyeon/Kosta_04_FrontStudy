package spring.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.service.domain.Member;
import spring.service.user.MemberDAO;
import spring.service.user.MemberService;

@Service
public class MemberServiceImpl implements MemberService	{
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public void registerMember(Member member) throws Exception {
		memberDAO.registerMember(member);
	}

	@Override
	public void updateMember(Member member) throws Exception {
		memberDAO.updateMember(member);
	}

	@Override
	public List<Member> showAllMember() throws Exception {
		List<Member> list = memberDAO.showAllMember();
		return list;
	}

	@Override
	public List<Member> getMember(Member member) throws Exception {
		List<Member> list = memberDAO.getMember(member);
		return list;
	}

	@Override
	public boolean idExist(String id) throws Exception {
		return memberDAO.idExist(id);
	}

	@Override
	public Member login(Member member) throws Exception {
		return memberDAO.login(member);
	}
	
}
