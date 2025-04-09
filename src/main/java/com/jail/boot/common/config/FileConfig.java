package com.jail.boot.common.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileConfig implements WebMvcConfigurer{
	
	//여긴 4/8일 수업중 에러나서 다시 자습시간에 새로작성함!
	//images/board/**" <-- 에서 **별별 하면 모든경로에서 처리하겠다?!하면 **적어준다!
	private final String WEB_PATH ="/images/board/**";
	//C:uploadImage/board <--파일 경로 업로드이미지 적어줌!!
	private final String REAL_PATH = "file:///C:/uploadImage/board/";
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(WEB_PATH).addResourceLocations(REAL_PATH);
	}
}
