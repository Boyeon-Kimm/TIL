package com.ssafy.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.model.dto.User;


//일단 rest1이라는 요청이 들어오면 이 controller로 배정을 해
@RestController  // Controller + ResponseBody
@RequestMapping("/rest2")
public class TestController2 {
	// 메소드를 쭉 작성할건데...
	
	// rest1의 test1dl 들어오면 이 메소드를 동작시키도록 해!
	// http://localhost:8080/mvc/rest2/test1 --> 404에러가 떴다.
	// 뷰 리졸버가 hi rest를 뷰 네임이라고 생각하고 경로를 만들어버린다.
	@GetMapping("/test1")
	public String test1() {
		return "hi rest";
	}
	
	// http://localhost:8080/mvc/rest2/test2 --> @ResponseBody
	// JSP 화면 그런거 반환이 아니라 데이터를 넘긴다.
	@GetMapping("/test2")
	public String test2() {
		return "hi rest";
	}
	

	// map을 반환하면 얘도 키 / 밸류니까 알아서 JSON으로 바꿔주지 않을까??
	@GetMapping("/test3")
	public Map<String, String> test3() {
		// Map은 key와 value를 가지고 있음
		Map<String, String> data = new HashMap<String, String>();
		
		data.put("id", "ssafy");
		data.put("password", "1234");
		data.put("name", "김싸피");
		
		// jackson 라이브러리 추가했더니 맵인데도 JSON으로 바꿔서 돌려줌
		return data;
	}
	
	// http://localhost:8080/mvc/rest2/test4 --> DTO 반환 해보자~
	// jackson이 객체도 알아서 JSON 형태로 바꾸어 주었다
	@GetMapping("/test4")
	public User test4() {
		User user = new User();
		user.setId("ssafy");
		user.setPassword("1234");
		user.setName("김보연");
		
		return user;
	}
	
	// http://localhost:8080/mvc/rest2/test4 --> List 반환 해보자~
	// 자바스크립트의 배열 형태로 알아서 바뀌어서 반환하더라
	@GetMapping("/test5")
	public List<User> test5() {
		List<User> list = new ArrayList<>();
		
		for(int i = 1; i <= 5; i++) {
			User user = new User();
			user.setId("ssafy" + i);
			user.setPassword("1234");
			user.setName("김보연" + "bot" + i);
			list.add(user);
		}
		
		return list;
	}
}
