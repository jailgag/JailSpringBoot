package com.jail.boot.board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jail.boot.board.controller.dto.BoardAddRequest;
import com.jail.boot.board.model.service.BoardService;

import lombok.extern.slf4j.Slf4j;

//@WebMvcTest(controllers = BoardControllerTest.class)
//@AutoConfigureMockMvc  <--실제로 저장해주는 어노테이션 코드!
//@Transactional  커밋을하지않고 롤백을 해주는어노테이션!!

@SpringBootTest
@AutoConfigureMockMvc 
//@Transactional //테스트 성공후 롤백!(4로 등록성공했는데 DB에는 저장안됨!) 저장하려면 저코드주석처리함!
@Slf4j
public class BoardControllerTest {
	
	//복붙!하고 BoardControllerTest로 바꿔줌!4/12시작
	private static final Logger LOGGER 
	= LoggerFactory.getLogger(BoardControllerTest.class);
	
//	//그래서 아래 코드는 지운다!! 주석처리함!!그리고 위에 @WebMvcTest 어노테이션 지움!주석처리!
//	@Autowired
//	private TestRestTemplate restTemplate; //url을 요청해주는?!위에 @WebMvcTest 어노테이션 같이 못쓴다?!
	
	@Autowired
	private MockMvc mockMvc; //에러나서 이코드 추가해주고 아래 코드 public void testWriteBoard  부분 주석처리해줌!!
	
	//의존성주입을 위해 아래코드작성!!!BoardController 위에 private final BoardService bService; 이있어서?
	
	@Autowired
	private BoardService boardService;
	
	@Test
	public void testWriteBoard () throws Exception {
		LOGGER.info("========testWriteBoard() 메소드 시작!!=========== ");
		
		// 가짜 이미지 파일 생성                                  	//파일이름   //파일  		
		//아래코드 작성후 아래 .file(image1)~~적어줌!
		//다시 테스트확인 유닛테스트5-1.jpg 로 등록 !테스트할때 저부분이 중요하다!
		MockMultipartFile image1 
		= new MockMultipartFile("images", "유닛테스트5-1.jpg","images/jpeg","test images content1".getBytes());
		MockMultipartFile image2 
		= new MockMultipartFile("images", "유닛테스트5-2.jpg","images/jpeg","test images content2".getBytes());
		
		//post 2번째 선택하고 url 적고!~.부분부터 임포트 확인해볼것!!
		//코드 수정 단계에서 post부분을 코드수정함!!
		//.contentType(MediaType.APPLICATION_JSON) <---이코드는 밑에 필요없어서 지움(주석처리해서 일단나둠!)
		//	.content(json)) <--이코드도 아래에서 지움!! 테스트 하고 지워줄예정!!!
		//아래코드 적어주고 BoardController로 감!!
				mockMvc.perform(multipart("/board/insert")
						.file(image1)
						.file(image2)
						.param("boardTitle", "유닛테스트 컨트롤러 등록5")
						.param("boardContent", "유닛테스트 컨트롤러 등록5"))
						//.andExpect(status().isOk()); // <--이걸 쓰면 에러남 그래서 아래코드씀!!
						.andExpect(redirectedUrl("/board/list"));
				
				
				//아래코드는 boardController에서 insert부분 
				//return "redirect:/board/list"; 이기때문에 아래 코드는 지워준다(주석처리함!!)
				//.andExpect(status().isOk());

		//		//아래코드~~~~ r.writeValueAsString(board);까지 지워준다!!주석처리함!!
		//boardcontroller에보면 modelAttribute를 사용하기때문에!!!!!*****
//		//아래코드적고!board servicetest 에서 복붙해서 가져오고 등록2로 바꿔줌!
//		BoardAddRequest board = new BoardAddRequest();
//		board.setBoardTitle("유닛테스트 게시글 등록2");
//		board.setBoardContent("유닛 테스트 게시글 등록2");
//		board.setMemberNo(2);
//		ObjectMapper objectMapper = new ObjectMapper();
//		//결과값을 json으로 받기위해 쓰는코드!밑에꺼 적고 add throws 던지고 Exception으로 선택!
//		String json = objectMapper.writeValueAsString(board);
		
		
		
		
		//밑에코드는 에러나서 주석처리함!
//		//결과값을 받기위해서 써주는 클래스!(첫번쩨는 url
//		ResponseEntity<String> response 
//		= restTemplate.postForEntity("/board/insert", board, String.class);
//		
//		//결과출력!
//		LOGGER.info(response.getBody());
//		
//		// HTTP 응답 상태 체크
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//		
		// 테스트 종료 메세지
		LOGGER.info(">>>>>>>>테스트 수행 종료!! <<<<<<<<<<<<<<");
	}
}
