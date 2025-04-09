package com.jail.boot.board.model.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Comment {
	private int commentNo;
	private String commentContent;
	private Date commentCreateDate;
	private String commentYn;
	private int boardNo;
	private int memberNo;
	private int parentNo;
}
