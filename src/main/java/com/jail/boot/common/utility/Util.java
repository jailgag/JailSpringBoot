package com.jail.boot.common.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	//4/9일코드추가
	public static int seqNum = 1;
	
	
	//여기도 다시 코드 확인및 못적은 다른곳에도 적기1!
	public static String fileRename(String originalFileName) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		//밑에코드는 초반 이미지 나오는거 확인하고 수정! 
		String date = sdf.format(new Date(System.currentTimeMillis()));
		//4/9 코드 1개추가! 
		String srt ="_" + String.format("%05d", seqNum++);
		String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
		return date + srt + ext;
	}
}
