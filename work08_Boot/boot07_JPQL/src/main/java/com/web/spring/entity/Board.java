package com.web.spring.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString
public class Board {
	
	@Id
	@Column(name="board_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardId;
	
	@Column(length = 100)
	private String title;
	
	@Lob
	private String content; //text Type

	private int count;
	
	@CreationTimestamp
	private LocalDateTime regDate; //글 입력되는 시간을 자동으로 생성
	
	//추가...
	//Custom...
	//한명의 회원이 여러개의 게시물을 작성 -> Board(N) ---- Custom(1) = ManyToOne
	@ManyToOne(fetch = FetchType.LAZY) //디폴트는 FetchType.EAGER
	@JoinColumn(name="custom_id")
 	private Custom custom;


	@Override public String toString() {
		return "Board [boardId=" + boardId + ", title=" + title + ", content=" + content + ", count=" + count + ", regDate=" + regDate + "]"; 
	}

	/*
	 * @Override public String toString() { return "Board [boardId=" + boardId +
	 * ", title=" + title + ", content=" + content + ", count=" + count +
	 * ", regDate=" + regDate + ", custom=" + custom + "]"; }
	 */
	
	
}











