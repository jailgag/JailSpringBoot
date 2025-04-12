package com.jail.boot.board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jail.boot.board.controller.dto.BoardAddRequest;
import com.jail.boot.board.model.service.BoardService;



@SpringBootTest
public class BoardServiceTest {
	
	private static final Logger LOGGER 
	= LoggerFactory.getLogger(BoardServiceTest.class);
	
	@Autowired
	private BoardService service;
	
	@BeforeAll
	public static void setUp() {
		LOGGER.info("테스트 전 셋팅 완료");
	}
	
	@Test
	public void testInsertBoard() {
		try {
			BoardAddRequest board = new BoardAddRequest();
			board.setBoardTitle("유닛테스트 게시글 등록1");
			board.setBoardContent("유닛 테스트 게시글 등록1");
			board.setMemberNo(2);
			//아래써주고 서라운드캐치!!
			assertEquals(1, service.insertBoard(board, null));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterAll
	public static void testComplate() {
		LOGGER.info("모든 테스트 완료!!");
	}
}
