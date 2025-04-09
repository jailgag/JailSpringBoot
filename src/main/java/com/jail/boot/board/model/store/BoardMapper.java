package com.jail.boot.board.model.store;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.session.SqlSession;

import com.jail.boot.board.controller.dto.BoardAddRequest;
import com.jail.boot.board.model.vo.Board;
import com.jail.boot.board.model.vo.BoardImg;

@Mapper
public interface BoardMapper {
	//만들기!!
	//작성해줄거있음!!없었음 확인!!옮겨줄때 insert부분에(select)포함!Sqlsession지워줌!
	//comment도 마찬가지로 작업!!
		//1.등록!
		int insertBoard(BoardAddRequest board);
		//detail
		Board selectOneByNo(int boardNo);
		//4/7 21:17 파일등록실습 만들어줌!(단일 파일 저장!!)
		int insertBoardImage(BoardImg img);
		//4/8일 파일실습2 만들어줌!BoardServiceImpl에서 왔음!(다중 파일 저장!!)
		int insertBoardImageList(List<BoardImg> imageList);
}
