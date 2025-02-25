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

				session.selectList("MemberMapper.findAllMember", pvo)
						.forEach(m -> System.out.println(m));
				
				System.out.println("===============================================");
				
				//아이디가 k로 시작하는 회원을 검색 like 연산자와 와일드카드 % 사용
				session.selectList("MemberMapper.getMember", "k")
						.forEach(m -> System.out.println(m));
				
				System.out.println("===============================================");
				
				//아이디가 BAEK5인 회원을 삭제
				int result = session.delete("MemberMapper.deleteMember", "BAEK5");
				System.out.println("삭제 결과 ==> " + result);
				
				session.commit();
				session.close();
	}

}
