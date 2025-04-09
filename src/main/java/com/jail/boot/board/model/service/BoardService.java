package com.jail.boot.board.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jail.boot.board.controller.dto.BoardAddRequest;
import com.jail.boot.board.model.vo.Board;

public interface BoardService {
	
	//단일 파일업로드
	//	int insertBoard(BoardAddRequest board, MultipartFile images) throws IllegalStateException, IOException;
	//다중파일!!업로드
	int insertBoard(BoardAddRequest board, List<MultipartFile> images) throws IllegalStateException, IOException;
	
	//detail 
	Board selectOneByNo(int boardNo);
}
