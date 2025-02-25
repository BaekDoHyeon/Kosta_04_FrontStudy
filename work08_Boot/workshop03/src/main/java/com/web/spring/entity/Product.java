package com.web.spring.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
	
	@Id
	@Column(name="pro_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long proNo;
	
	private String model;
	
	private String maker;
	
	@CreationTimestamp
	private LocalDateTime regDate;

	@Override
	public String toString() {
		return "Product [proNo=" + proNo + ", model=" + model + ", maker=" + maker + ", regDate=" + regDate + "]";
	}
	
}




