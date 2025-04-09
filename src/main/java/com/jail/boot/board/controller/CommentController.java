package com.jail.boot.board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jail.boot.board.model.service.CommentService;
import com.jail.boot.board.model.vo.Comment;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommentController {

   
	
	//의존성주입 위에 @RequiredArgsConstructor로쓴다!
	
	private final CommentService service;

	
	//@ResponseBody대신에 위에 @RestController로 쓴다!
	
	@PostMapping("/comment/insert")
	public int insertComment(@RequestBody Comment comment) {
		//요청된 데이터(JSON)을 HttpMessageConverter가 해석하여 Java 객체(comment)에 매핑해줌!
		System.out.println(comment);//값이 넘어오는지 확인작업아래 //(사용자가 입력한 데이터 확인!!)
		int result = service.insertComment(comment);
		//사용자가 입력한 값이 넘어오는지 확인작업코드 //(DB값 결과 확인!!)
		System.out.println(result);
		return result;
	}
	//아래코드 4/5일 detail.jsp에 스크립트에 코드작성후 아래 코드 적어줌!!
	
	@GetMapping("/comment/list")
	public List<Comment> selectCommentList(int boardNo) {
		return service.selectCommentList(boardNo);
	}
}
