package com.web.spring.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	private String password;
	
	@Column(length = 20)
	private String name;
	
	// User 와 Product 사이에 다대다 관계를 해소하기 위한 조인테이블/조인컬럼
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="orderlist", 
	   joinColumns = @JoinColumn(name="user_id"), 
	   inverseJoinColumns = @JoinColumn(name="pro_no"))
	List<Product> products = new ArrayList<>();

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + "]";
	}
	
}











