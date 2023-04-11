package com.ssafy.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "p")
public class Programmer {
//	@Autowired
//	@Qualifier("laptop")
	private Computer computer;
	
//	public Programmer() {
//	}
//	@Autowired
	public Programmer(Computer computer) {
		this.computer = computer;
	}
	
//	@Autowired
//	public void setComputer(@Qualifier("desktop") Computer computer) {
//		this.computer = computer;
//	}
	
	
	
	public void coding() {
		System.out.println(computer.getInfo()+"으로 개발을 합니다.");
	}
}
