package spring.service.test;

import java.io.IOException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import spring.service.domain.Member;

public class MyBatisMemberTestApp {

	public static void main(String[] args) throws IOException {
				Member pvo = new Member();
				pvo.setId("BAEK5");
				pvo.setPassword("BAEK1234");
				pvo.setName("BAEKDOHYEON");
				pvo.setAddress("Incheon");
	
				SqlSessionFactory factory = TestUtil.getFactory();
				SqlSession session = factory.openSession();
				
				System.out.println("SqlSession...Creating...");
				
				session.insert("MemberMapper.registerMember", pvo);
				
				System.out.println(pvo.getName() + " 님 회원 등록 성공^^");

				session.selectList("MemberMapper.showAllMember", pvo)
						.forEach(m -> System.out.println(m));
				
				System.out.println("===============================================");
				
				//아이디가 BAEK5 인 회원의 주소를 Incheon -> Seoul 로 변경
				pvo.setAddress("Seoul");
				session.update("MemberMapper.updateMember", pvo);
				
				//아이디가 BAEK5로 시작하는 회원을 검색 혹은 주소가 Seoul인 유저 검색 like 연산자와 와일드카드 % 사용
				session.selectList("MemberMapper.getMember", pvo)
						.forEach(m -> System.out.println(m));
				
				System.out.println("===============================================");
				
				//아이디가 "1234"인 회원이 존재하는지 확인
				boolean result = session.selectOne("MemberMapper.idExist", "1234");
				
				if(result)
					System.out.println(pvo.getId() + "의 id를 가진 회원이 존재합니다.");
				else
					System.out.println(pvo.getId() + "의 id를 가진 회원이 존재하지 않습니다.");
				
				System.out.println("===============================================");
				
				//아이디 BAEK5 와 패스워드 BAEK1234 로그인
				System.out.println(session.selectOne("MemberMapper.login", pvo).toString());
				
				System.out.println("===============================================");
				
				//아이디가 BAEK5인 회원을 삭제
				int resultDelete = session.delete("MemberMapper.deleteMember", "BAEK5");
				System.out.println("삭제 결과 ==> " + resultDelete);
				
				session.commit();
				session.close();
	}

}
