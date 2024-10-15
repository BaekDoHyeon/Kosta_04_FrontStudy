package com.web.spring;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.web.spring.entity.Board;
import com.web.spring.entity.Custom;
import com.web.spring.repository.BoardRepository;
import com.web.spring.repository.CustomRepository;
import com.web.spring.repository.RoleRepository;

@SpringBootApplication
public class Boot07JpqlApplication implements CommandLineRunner {

	@Autowired 
	RoleRepository roleRepository;
	
	@Autowired
	CustomRepository customRepository;
	
	@Autowired
	BoardRepository boardRepository;
	
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		//1. 모든 게시글 검색... findAll()
		/*
		 * boardRepository.findAll().forEach(b -> { System.out.println(b);
		 * System.out.println(b.getCustom()); });
		 */
		
		//2. JPQL...
		/*
		 * boardRepository.getBoards().forEach(b -> { System.out.println(b);
		 * System.out.println(b.getCustom()); });
		 */
		
		/*
		 * Long boardCount = boardRepository.getBoardCount();
		 * System.out.println("전체 게시글의 갯수 ==>" + boardCount);
		 */
		
		//3. admin 권한을 가지는 사람이 작성한 게시글을 다 검색...
		/*
		 * Role role = roleRepository.findById(2).get(); //role은 ADMIN 권한을 가지고 있다.
		 * System.out.println("Role==>" + role);
		 * 
		 * Custom c = new Custom(); c.setName("한강"); c.setEmail("han@google.com");
		 * c.setPassword("7777"); c.setRegDate(LocalDateTime.now());
		 * c.setRoles(Set.of(role)); //사용자에 권한을 주입...Set으로
		 * 
		 * customRepository.save(c); //사용자 생성
		 */	
		
		//4. admin 권한을 가지는 13번 사용자가 게시글을 작성
		/*
		 * Custom c = customRepository.findById(13).get(); Board b = new Board();
		 * b.setCustom(c); b.setTitle("관리자 권한 작성"); b.setContent("관리자 권한을 가지고 있어요");
		 * b.setRegDate(LocalDateTime.now());
		 * 
		 * boardRepository.save(b); //관리자 권한을 가지는 사람이 게시글을 작성
		 */	
			
		//5. 
		/*
		 * boardRepository.getBoards("ROLE_ADMIN") .forEach(b -> {
		 * System.out.println(b); System.out.println(b.getCustom()); });
		 */
		
		/*
		 * boardRepository.getBoardsNative() .forEach(b -> { System.out.println(b);
		 * System.out.println(b.getCustom()); });
		 */
		
		boardRepository.getBoardsNative2()
		   .forEach(b -> {
			   System.out.println(b.getClass().getName());
			   System.out.print(b.getContent());
			   System.out.print(b.getTitle()); 
			   System.out.print(b.getCustomId());
			   System.out.print(b.getBoardId());
			   System.out.println(b.getName());
		   });
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Boot07JpqlApplication.class, args);
	}

}






