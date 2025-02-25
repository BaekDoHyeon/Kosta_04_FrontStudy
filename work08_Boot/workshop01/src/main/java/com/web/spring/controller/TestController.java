package com.web.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.dto.Product;

@RestController
public class TestController {
	
	//1. No가 1234인 상품을 검색하는 요청을 작성 – 파라미터로 넘어온 값을 받는다.
	@PostMapping("/product")
	public ResponseEntity<?> productFindRequestBody(@RequestBody String no) {
		return ResponseEntity
				.status(200)
				.body(no + " 검색 완료");
	}
	
	//2. No가 1234인 상품을 검색하는 요청을 작성 – 요청시 주소창에 바로 입력된다.
	@GetMapping("/product/{no}")
	public ResponseEntity<?> productFindPathVariable(@PathVariable String no) {
		return ResponseEntity
				.status(200)
				.body(no + " 검색 완료");
	}
	
	//3. 모든 상품의 정보를 가져오는 요청을 작성 
	@GetMapping("/products")
	public ResponseEntity<?> getProducts() {
		return ResponseEntity
				.status(200)
				.body("모든 상품의 정보 가져오기 완료");
	}
	
	
	//4. 하나의 상품을 등록하는 요청을 작성 
	@PostMapping("/product/add")
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		return ResponseEntity
				.status(201)
				.body("["+product.getId()+"] " + product.getName() + " 의 상품이 등록되었습니다.");
	}
	
	//5. 특정한 상품정보를 수정하는 요청을 작성 
	@PutMapping("/product/{no}")
	public ResponseEntity<?> updateProduct(@RequestBody Product product) {
		return ResponseEntity
				.status(200)
				.body("["+product.getId()+"] " + product.getName() + " 의 상품이 수정되었습니다.");
	}
	
	
	//6. 특정한 상품정보를 삭제하는 요청을 작성 
	 @DeleteMapping("/product/{no}")
	 public ResponseEntity<?> deleteProduct(@RequestBody Product product) {
			return ResponseEntity
					.status(200)
					.body("["+product.getId()+"] " + product.getName() + " 의 상품이 삭제되었습니다.");
		}

}
