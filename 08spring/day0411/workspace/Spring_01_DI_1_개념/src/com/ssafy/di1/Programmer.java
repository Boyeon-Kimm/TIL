package com.ssafy.di1;

public class Programmer {
	//캡슐화 적용해보자.
	private Desktop computer;
	
	public Programmer() {
		computer = new Desktop();
	}
	
	public void coding() {
		System.out.println(computer.getInfo()+"으로 개발을 한다.");
	}
}
