package spring.service.test;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.domain.Member;
import spring.service.user.MemberDAO;
import spring.service.user.MemberService;

public class MyBatisMemberTestApp2 {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"/bean/memberservice.xml"});
		
		//==> IoC Container 로 부터 획득한 UserDAO 인스턴스 획득
		MemberService memberService = (MemberService)context.getBean("memberServiceImpl");
		
		Member member = new Member("BAEK5","BAEK1234","BAEKDOHYEON","Incheon");
		
		System.out.println("memberSerivce Testing...");
		
		memberService.registerMember(member);
		
		System.out.println(member.getName() + " 님 회원 등록 성공^^");
		
		memberService.showAllMember()
				.forEach(m -> System.out.println(m));
		
		System.out.println("===============================================");
		
		//아이디가 BAEK5 인 회원의 주소를 Incheon -> Seoul 로 변경
		member.setAddress("Seoul");
		memberService.updateMember(member);
		
		//아이디가 BAEK5로 시작하는 회원을 검색 혹은 주소가 Seoul인 유저 검색 like 연산자와 와일드카드 % 사용
		memberService.showAllMember()
				.forEach(m -> System.out.println(m));
		
		System.out.println("===============================================");
		
		//아이디가 "1234"인 회원이 존재하는지 확인
		if(memberService.idExist(member.getId()))
			System.out.println(member.getId() + "의 id를 가진 회원이 존재합니다.");
		else
			System.out.println(member.getId() + "의 id를 가진 회원이 존재하지 않습니다.");
		
		System.out.println("===============================================");
		
		//아이디 BAEK5 와 패스워드 BAEK1234 로그인
		System.out.println(memberService.login(member));
		
		System.out.println("===============================================");
		
		//아이디가 BAEK5인 회원을 삭제
		MemberDAO memberDAO = (MemberDAO)context.getBean("memberDAOImpl");
		
		int result = memberDAO.deleteMember(member.getId());
		System.out.println("삭제 결과 ==> " + result);
	}

}
