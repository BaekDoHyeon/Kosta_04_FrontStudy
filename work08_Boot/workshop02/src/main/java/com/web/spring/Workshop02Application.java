package com.web.spring;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.spring.entity.User;
import com.web.spring.repository.UserRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Workshop02Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		/*
		 * 유저 등록 User user = new User(); user.setUserId("letgogogo");
		 * user.setName("황희찬"); user.setPassword("hwang1234");
		 * userRespository.save(user);
		 */

		/*
		 * 유저 id로 검색 User findIdUser = userRepository.findById("A1234").get();
		 * System.out.println(findIdUser);
		 */

		/*
		 * 전체 유저 검색 userRepository.findAll().forEach(u -> System.out.println(u));
		 */

		
		 //유저 삭제 -> 쿼리가 4번 돌아간다. (select -> insert -> select -> delete) -> @Transactional 붙으면 3번 돌아감 (select -> insert -> delete)
		/*
		 * User addUser = new User("s12354213", "설영우", "pwd1234");
		 * userRepository.save(addUser); 
		 * userRepository.delete(addUser);
		 */
		 

		/*
		 * 유저 수정 -> @Transactional 없으니 update 쿼리가 나가지 않는다. 
		 * User updateUser = userRepository.findById("letgogogo").get(); 
		 * System.out.println("수정 전 >>> " + updateUser); 
		 * updateUser.setPassword("hwang9999");
		 * System.out.println("수정 후 >>> " + updateUser);
		 */

		// 1. 모든 고객을 가지고 오는데, 이름 오름차순으로 정렬 - findByAgeOrderByLastnameDesc
		// userRepository.findByOrderByName().forEach(u -> System.out.println(u));

		// 2. 성을 이용하여 이름 검색 - findByFirstnameStartingWith
		// userRepository.findByNameStartingWith("손").get().forEach(u ->
		// System.out.println(u));

		// 3. 로그인 기능
		/*
		 * User loginUser = userRepository.findByUserIdAndPassword("A1234", "son12345")
		 * .orElseThrow(() -> new NoSuchElementException("해당 유저는 존재하지 않습니다."));
		 * System.out.println("[로그인 완료] 유저 정보 >> " + loginUser);
		 */
	}

	public static void main(String[] args) {
		SpringApplication.run(Workshop02Application.class, args);
	}

}
