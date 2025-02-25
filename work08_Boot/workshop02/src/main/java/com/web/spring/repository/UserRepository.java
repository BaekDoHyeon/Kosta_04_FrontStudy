package com.web.spring.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.spring.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	//1. 모든 고객을 가지고 오는데, 이름 오름차순으로 정렬 - findByAgeOrderByLastnameDesc
	List<User> findByOrderByName();
	
	//2. 성을 이용하여 이름 검색 - findByFirstnameStartingWith
	Optional<List<User>> findByNameStartingWith(String firstName);
	
	//3. 로그인 기능 - findByLastnameAndFirstname
	Optional<User> findByUserIdAndPassword(String name, String password);
	
}
