package com.ssafy.di;

public class Desktop implements Computer {
	// 필드명 작성
	// CPU, 그래픽카드, 키보드 등등 사양
	
	public Desktop() {
		System.out.println("데스크탑 생성");
	}
	public String getInfo() {
		return "데스크톱";
	}
}
