package com.jail.boot.board.model.service;

import java.util.List;

import com.jail.boot.board.model.vo.Comment;

public interface CommentService {
	
	//댓글등록!
	int insertComment(Comment comment);
	//댓글 리스트??
	List<Comment> selectCommentList(int boardNo);

}
