package com.jail.boot.board.model.vo;

import java.sql.Date;
//import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//아래setter는 필요없었음?!!
//@Setter

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	//색깔 바꾸기!!아니면 에러임!! 테이블이랑 확인해볼것!!**확인!!
	//원래는 BoardVO인데 Board로 바꿈!!
	//실행할때 어디선가 바꿨다??확인!!문제없음!
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private Date boardCreateDate;
	private Date boardUpdateDate;
	private int readCount;
	private String boardYn;
	//4/4일 오전 추가!!
	//댓글 목록!
	private List<Comment> commentList;
	//첨부파일(4/8일추가)/ 이미지(detail.jsp에 img태그에 아래코드 같은지 확인! 
	//단일첨부파일아래주석!
	//private BoardImg boardImg;
	//다중 첨부파일! 4/9일 추가!
	private List<BoardImg> imgList;
	
}
