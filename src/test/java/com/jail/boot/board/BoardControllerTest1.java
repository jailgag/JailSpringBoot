package com.jail.boot.board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class BoardControllerTest1 {
	
	//이코드는 어디다 쓰일것인가... 강사님 코드!! 등록은 확인됨! 일단 올리기!!
	private static final Logger LOGGER = LoggerFactory.getLogger(BoardControllerTest1.class);

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testWriteBoard() {
		LOGGER.info("======= testWriteBoard() 메소드 시작 ======");

		// (1) 멀티파트 전송을 위한 헤더 설정
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.MULTIPART_FORM_DATA);

	    // (2) 텍스트 파트: BoardAddRequest 내용을 Map으로 구성
	    MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
	    body.add("boardTitle", "멀티파트 게시글 제목");
	    body.add("boardContent", "멀티파트 게시글 내용");
	    body.add("memberNo", "2");

	    // (3) 파일 파트: 실제 파일 대신 ByteArray 리소스 사용 (테스트용)
//	    ByteArrayResource resource = new ByteArrayResource("파일내용입니다.".getBytes(StandardCharsets.UTF_8)) {
//	        @Override
//	        public String getFilename() {
//	            return "testfile.txt";
//	        }
//	    };
//	    body.add("images", resource);  // 컨트롤러에서 @RequestPart("file")로 받는다고 가정

	    // (4) HttpEntity로 묶기
	    HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

	    // (5) 요청 보내기
	    ResponseEntity<String> response = restTemplate.postForEntity("/board/insert", requestEntity, String.class);

		LOGGER.info(response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
		LOGGER.info(">>>>> 테스트 수행 종료 <<<<<");
	}
}
