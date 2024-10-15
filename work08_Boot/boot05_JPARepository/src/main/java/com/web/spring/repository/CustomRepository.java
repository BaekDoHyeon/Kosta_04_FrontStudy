package com.web.spring.repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.spring.entity.Custom;

/*
 * Spring Data JPA Repository... 이전의 DAO와 같은 역할
 * 인터페이스가 나오면 해당 인터페이스를 구현한 실체 클래스를 다시 상속받아서 작성해야 하지만
 * Spring Data JPA 기술은 인터페이스를 구현하는 빈 클래스를 자동으로 생성시켜준다.
 */
public interface CustomRepository extends JpaRepository<Custom, Integer> {
	// 아무것도 작성 안해도 기본적인 CRUD가 다 들어있따...
	
	// JPA Query Method... 추가
	/*
	 	JPA Query Method
	 	1. 대부분 findBy로 시작
	 	2. 이름 규칙만 잘 정해주면 자동으로 SQL 구문이 실행
	 	3. ORM 방식이기 때문에 함수명은 CamelCase 가 기본이다.
	 */
	
	Optional<List<Custom>> findByName(String name);
	
	//findByLastnameAndFirstname
	Optional<Custom> findByNameAndEmail(String name, String email);
	
	//findByLastnameOrFirstname
	List<Custom> findByNameOrEmail(String name, String email); 
	
	//고객의 아이디값이 1~3 사이의 아이디를 가지는 고객을 검색
	//findByStartDateBetween
	Optional<List<Custom>> findByCustomIdBetween(int startCustomId, int endCustomId);
	
	//고객의 아이디가 3보다 작은 아이디를 가지는 고객을 검색
	//findByAgeLessThan
	Optional<List<Custom>> findByCustomIdLessThan(int customId);
	
	//고객의 등록일자가 어제(LocalDateTime) 이후로 등록한 고객을 검색...
	//findByStartDateAfter
	Optional<List<Custom>> findByRegDateAfter(LocalDateTime day);
	Optional<List<Custom>> findByRegDateBefore(LocalDateTime day);
	
	//고객의 이름이 null 값인 고객을 검색
	//findByAge(Is)Null
	List<Custom> findByNameNull(); //Is 붙여야 하는건가??
	
	//select * from custom where name like "name";
	List<Custom> findByNameLike(String name); //와일드카드 적용 안됨. 적용하려면 인자값에 와일드카드를 같이 지정해주어야 한다.
	
	//findByFirstnameContaining
	List<Custom> findByNameContaining(String name);
	
	//findByFirstnameStartingWith
	//findByFirstnameEndingWith
	List<Custom> findByNameEndingWith(String name);
	
	//findByAgeOrderByLastnameDesc
	List<Custom> findByOrderByCustomIdDesc();
	List<Custom> findByOrderByCustomId();
	
	//고객 아이디가 3보다 큰 아이디를 가지는 고객을 검색 + 아이디를 내림차순 정렬
	//findByAgeGreaterThan +  findByOrderByCustomIdDesc -> 이런식으로 조건검색 뒤에 OrderBy 절은 다 붙일 수 있다.
	Optional<List<Custom>> findByCustomIdGreaterThanOrderByCustomIdDesc(int customId);
	
	//findByAgeIn(Collection<Age> ages)
	Optional<List<Custom>> findByCustomIdIn(Collection<Integer> customIds);
	
	//Not은 null과 비교하지 않는다... null은 출력되지 않는다.
	List<Custom> findByNameNot(String name);
}






