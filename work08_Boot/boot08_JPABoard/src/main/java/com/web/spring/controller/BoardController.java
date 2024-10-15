package com.web.spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.dto.BoardReq;
import com.web.spring.dto.BoardRes;
import com.web.spring.entity.Board;
import com.web.spring.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;
	
	/**
	* 전체 게시물 조회
	* */
	@GetMapping("/boards")
	public List<BoardRes> findAll() {
		return boardService.boardList();
	}
	
	/**
	 * 글번호에 해당하는 게시물 조회
	 * */	
	@GetMapping("/boards/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		//Long boardId = Long.parseLong(id);
		Board board = boardService.findBoard(id);
		return ResponseEntity
				.status(200)
				.body(board + "");
	}
	
    /**
	 * 게시물 등록
	 * */
	@PostMapping("/boards/add")
	public ResponseEntity<?> save(@RequestBody BoardReq boardReq){
		Board board = boardService.addBoard(boardReq);
		return ResponseEntity
				.status(201)
				.body(board.getId() + "글이 등록되었습니다.");
	}
	
	/**
	 * 글번호에 해당하는 게시물 수정
	 */
	@PutMapping("/boards/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BoardReq boardReq){
		return new ResponseEntity<>(boardService.updateBoard(id, boardReq), HttpStatus.OK);		
	
	}
	
	/**
	 * 글번호에 해당하는 게시물 삭제
	 * */
	@DeleteMapping("/boards/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){		
		return new ResponseEntity<> (boardService.deleteBoard(id), HttpStatus.OK);
	}
}




