package com.web.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.spring.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findTop2ByOrderByProNo();
}
