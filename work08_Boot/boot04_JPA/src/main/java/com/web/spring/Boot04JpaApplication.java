package com.web.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.spring.entity.Custom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
//Spring Framework 에서 빈으로 제공되는 것들을 사용하기 위해서 CommandLineRunner!!!
@SpringBootApplication
public class Boot04JpaApplication implements CommandLineRunner {
	
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	@Override
	public void run(String... args) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		try {
			transaction.begin();
			
			/* persist + find
			 * Custom c= new Custom(); c.setName("James7"); c.setPassword("7777");
			 * c.setEmail("james@google.com");
			 * 
			 * entityManager.persist(c);
			 * 
			 * Custom find7 = entityManager.find(Custom.class, 7);
			 * System.out.println("7번에 해당하는 고객 정보..." + find7);
			 */
			
			
			//수정...UPDATE가 존재하지 않는다.
			//7번 고객의 정보를 수정
			/*
			 * Custom find7 = entityManager.find(Custom.class, 7);
			 * find7.setPassword("9999"); //패스워드를 변경
			 * 
			 * System.out.println("7번 고객의 정보 " + find7);
			 */
			
			transaction.commit();
		} catch(Exception e) {
			transaction.rollback();
			
		} finally {
			entityManager.close();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Boot04JpaApplication.class, args);	
	}
	
}
