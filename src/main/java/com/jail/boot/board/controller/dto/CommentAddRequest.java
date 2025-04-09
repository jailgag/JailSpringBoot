package com.jail.boot.board.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentAddRequest {
	//객체를 초기화 할때 매개변수가 있는 생성자로 초기화를 해야 객체 불변성 보존
	//setter와 AllArgsConstructor (<---철자확인!!) 를 같이 쓰면 객체의 값이 setter에 의해서
	//변할수 있음!!
	//@NoArgsConstructor <--기본생성자!!
	//@AllArgsConstructor <--매게변수가있는생성자!
	private int boardNo;
	private String commentContent;
	private int memberNo;
	private int parentNo;
}
