package com.ssafy.aop;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Ssafy implements Person{
	// 필드는 필요 없고
	
	// 프로그래머의 일상
	public int coding() throws OuchException {
		System.out.println("열심히 코드를 작성한다.");
		if(new Random().nextBoolean())
			throw new OuchException();
		return (int)(Math.random() * 100) + 1;
	}
}
