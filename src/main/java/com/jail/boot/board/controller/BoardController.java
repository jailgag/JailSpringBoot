package com.jail.boot.board.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jail.boot.board.controller.dto.BoardAddRequest;
import com.jail.boot.board.model.service.BoardService;
import com.jail.boot.board.model.vo.Board;
//import com.jail.boot.common.controller.ExceptionController;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

   
	
	//아래 에러도 확인!!확인했음!!
	//아래코드에 "final"이 들어가는것 확인잘해야한다!~!! 
	private final BoardService bService;

   
	
	@GetMapping("/insert")
	public String showWriteForm() {
		//System.out.println("확인");
		return "board/insert";
	}
	
	// MultipartFile images로 바꿈!!
	//4/8일 21:45분에 첨부파일여러개 하는거 하면서 코드 바꾸기 시작!!
	
	@PostMapping("/insert")
	public String WriteBoard(@ModelAttribute BoardAddRequest board,
//			@RequestParam("images") MultipartFile images <--단일파일 아래코드는 다중파일코드!!
			
			@RequestParam("images") List<MultipartFile> images 
			,HttpSession session
			,Model model) throws IllegalStateException, IOException {
		System.out.println(images);
		//단일
//		int result = bService.insertBoard(board, images);
		//다중
		System.out.println(images);
		int result = bService.insertBoard(board, images);
		return "redirect:/board/list";
	}
	//적을거 많음!! 아래 코드 적기전에 다시 시작!!
	@GetMapping("/{boardNo}")
	public String boardDetail(@PathVariable("boardNo") int boardNo
			,Model model) {
		Board board = bService.selectOneByNo(boardNo);
		System.out.println(board);
		model.addAttribute("board",board);
		return "board/detail";
	}
}
