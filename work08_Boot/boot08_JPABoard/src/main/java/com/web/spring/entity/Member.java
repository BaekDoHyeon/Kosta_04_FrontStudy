package com.web.spring.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * 생성자 패턴...
 * Blog blog = new Blog(o, o, o, o, o);
 * 
 * 빌드 패턴...
 * Blog blog = Blog.builder()
 *  			.name("kosta")
 *  			.id("1234")
 *  			.memo("Good~")
 *  			.build();
 *  1. 빌더의 각 값들이 생성자 말고 빌더를 통해서 주입... 정확도가 높다.
 *  2. 생성자보다 가독력도 좋다.
 *  3. 다양한 인자값으로 객체 생성시...생성자 오버로딩시..~~~
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder //추가!!
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberNo;
	
	@Column(length = 20)
	private String id;
	private String pwd;
	private String name;
	private String address;
	private LocalDateTime regDate;
	
	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", address="
				+ address + ", regDate=" + regDate + "]";
	}
	
}
