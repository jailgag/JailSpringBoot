package com.jail.boot.board.model.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.jail.boot.board.model.service.CommentService;
import com.jail.boot.board.model.store.BoardMapper;
import com.jail.boot.board.model.store.CommentMapper;
//import com.jail.boot.board.model.store.CommentStore;
import com.jail.boot.board.model.vo.Comment;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
	
	//여기도 Mapper클래스작업후 코드 지우거나 적어줘야한다!!
	//04/07 19:54분 못했던실습시작!
	
	//아래 주석처리하고 private final CommentMapper mapper; 적어줌!!04/07 19:59
	//private final CommentStore store; 
	private final SqlSession session;
	//결국 ***********아래코드만 남기고 지워줌.....
	private final CommentMapper mapper;
	//3번째코드 04/07 20:20분 코드 추가작성(이번엔bmapper라고 적어줌..코드복잡코드왔음..
	//다시 왜인지 모르지만 아래 bmapper지워줌....주석처리하고 다시써줌!!
	//private final BoardMapper bmapper;지워준게 아니라 아예지워줌....주석처리!!
	//private final Board
	
	@Override
	public int insertComment(Comment comment) {
		//아래코드도 주석처리하고 새로작성!!
		//int result = store.insertComment(session,comment);
		int result = mapper.insertComment(comment);
		return result;
	}

	@Override
	public List<Comment> selectCommentList(int boardNo) {
		//아래코드는 변수 안쓰고 쓰는코드!!어디서 본적있는 코드...디버깅할때 어려움이있으나 코드가 줄어드는장점!
		//역시 아래코드도 주석처리하고 새로 작성!!
		//return store.selectCommentList(session, boardNo);
		//다시 코드 바꿔주는코드작성!,,,,다시 원복시킴.....
		return mapper.selectCommentList(boardNo);
	}
	
}
