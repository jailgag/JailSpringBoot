package com.jail.boot.board.model.store;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.session.SqlSession;

import com.jail.boot.board.model.vo.Comment;

@Mapper
public interface CommentMapper {
	//여기다가 StoreLogic에 있는거 옮기기 작업!!boardMapper도 옮겨줌!!
	//옮겨주는 작업후 Store에있는거 바탕화면에 옮겨줌(혹시모르니깐 !!)지웠다가 
	//에러나서 다시 돌려놓음!!
	
	//댓글등록!
		int insertComment(Comment comment);
		//댓글리스트??아니면 게시판리스트?
		List<Comment> selectCommentList(int boardNo);

}
