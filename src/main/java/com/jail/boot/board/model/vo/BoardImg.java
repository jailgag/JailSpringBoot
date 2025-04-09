package com.jail.boot.board.model.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoardImg {
	private int imgNo;
	private String imgPath;
	private String imgRename;
	private String imgOriginalName;
	private int imgOrder;
	private int boardNo;
	//MultipartFile 객체추가 주석처리함!다시 살리기 살려줌!!(MultipartFile 객체 추가)
	private MultipartFile imageFile;
}
