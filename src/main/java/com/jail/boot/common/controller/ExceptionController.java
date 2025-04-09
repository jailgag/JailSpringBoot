package com.jail.boot.common.controller;

import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	//오타는 잡았는데 실행할때 에러나면 여기볼것!!
	//어디에 사용??? 예외처리 할때 쓰는거?!!!!
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandlder(Exception e, Model model) {
		e.printStackTrace();
		// **** 임포트 안먹힘!!오타 에러!.!
		model.addAttribute("e",e);
		//아래코드는 필요없나봄..주석처리 알고있어라!
		//model.addAttribute("msg",e.getMessage());
		return "common/error";
	}
}
