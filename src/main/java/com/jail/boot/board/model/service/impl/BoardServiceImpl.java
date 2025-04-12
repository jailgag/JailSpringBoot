package com.jail.boot.board.model.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jail.boot.board.controller.dto.BoardAddRequest;
import com.jail.boot.board.model.service.BoardService;
import com.jail.boot.board.model.store.BoardMapper;
//import com.jail.boot.board.model.store.BoardStore;
import com.jail.boot.board.model.vo.Board;
import com.jail.boot.board.model.vo.BoardImg;
import com.jail.boot.common.utility.Util;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	
	private final SqlSession session;
	
	private final BoardMapper mapper;
	
	private String webPath ="/images/board/";
	private String folderPath = "C:/uploadImage/board/";
	
	@Override
	public Board selectOneByNo(int boardNo) {
		//아래코드도 마찬가지로 mapper로 코드옮기고 주석처리하고 새로 코드 작성
		//Board board = bStore.selectOneByNo(session,boardNo);
		Board board = mapper.selectOneByNo(boardNo);
		return board;
	}

	@Override
	public int insertBoard(BoardAddRequest board, List<MultipartFile> images)
			throws IllegalStateException, IOException {
		int result = mapper.insertBoard(board);
		//게시글 등록 실패시!!return 밑으로 코드 진행 안된다!!
		if(result == 0) return 0;
		//게시글 번호 꺼내기!!
		int boardNo = board.getBoardNo();
		List<BoardImg> imageList = new ArrayList<BoardImg>();
		//4/11 코드 추가해줌!그리고 if 안에 코드넣어주고 아래 4/11
		if(images != null) {
			for(int i = 0; i < images.size(); i++) {
				if(images.get(i).getSize() > 0) {
					BoardImg img = new BoardImg();
					//img에 파일 정보를 담기!!
					img.setBoardNo(boardNo);
					img.setImgOrder(i);
					
					String fileName = images.get(i).getOriginalFilename();
					String fileRename = Util.fileRename(fileName);
					img.setImgOriginalName(fileName); //오타!!!!***4/9
					img.setImgRename(fileRename);
					img.setImgPath(webPath+fileRename);
					img.setImageFile(images.get(i)); //여기적고 나서 BoardImg적어줘야함!! 1:10분부터!!
					//img를 imageList에 추가!!
					imageList.add(img);
					//1:06분 15초부터 코드적기!
				}//여기부터 아래코드 4/11강의때 한칸 올려줌!!***
			}//images -> imageList 처리 작업종료 
			//1.처리후 ImageList에 정보를 DB에 Insert 해야함!!
			//2.실제 파일저장!!
			if(!imageList.isEmpty()) {
				//1. imageList정보를 DB에 insert해야함.
				result = mapper.insertBoardImageList(imageList);
				//2. 실제 파일 저장!!
				for(BoardImg img: imageList) {
					img.getImageFile().transferTo(new File(folderPath+img.getImgRename())); //오타!!04/09
					//System.out.println("저장확인!!!");
				}
			}
		}
		return result;
	}

}
