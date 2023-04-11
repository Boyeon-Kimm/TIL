package com.ssafy.di2;

public class Programmer {
	//캡슐화 해보자
	private Desktop computer;
	
	//생성자 주입
	//더이상 new를 하지않고 외부에서 만든 생성자를 넣어준다. 
	//객체생성 의존성 제거
	public Programmer(Desktop computer) {
//		computer = new Desktop();
		this.computer = computer;
	}
	
	public void coding() {
		System.out.println(computer.getInfo()+"으로 개발을 합니다.");
	}
}
