package com.ssafy.di3;

public class Programmer {
	private Computer computer;
	
	//생성자 주입
	public Programmer(Computer computer) {
//		computer = new Desktop();
		this.computer = computer;
	}
	
	//setter(설정자) 주입 
	//필드 이름에 set을 붙이고 만들기
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	
	
	public void coding() {
		System.out.println(computer.getInfo()+"으로 개발을 합니다.");
	}
}
