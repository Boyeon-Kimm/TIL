package com.ssafy.rest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.model.dto.User;

@RestController // Controller + ResponseBody
@RequestMapping("/rest4")
public class TestController4 {
	
//	@PathVariable : URL 경로에 있는 값을 파라미터로 추출하겠다.
//	http://localhost:8080/컨텍스트루트/rest4/board/1 --> GET방식으로 보냈을 때 데이터를 얻어옴
//	http://localhost:8080/컨텍스트루트/rest4/board/2 --> GET방식으로 보냈을 때 데이터를 얻어옴
//	http://localhost:8080/컨텍스트루트/rest4/board/99 --> 해당 글의 번호가 들어왔다.
	
//	@GetMapping("/board/{id}")
//	// {id} 뽑아와 ! => PathVariable
//	public String test1(@PathVariable int id) {
//		return id + " : come on";
//	}
	
	@GetMapping("/board/{id}")
	// no 라고 하는 것은 {id} 입니다 => PathVariable("id")
	public String test1(@PathVariable("id") int no) {
		return no + " : come on yo";
	}
	
	// 게시글 등록을 해보자.
	// application/x-www-form-urlencoded : 폼으로 넘기면 알아서 잘 들어간다~~
//	@PostMapping("/board")
//	public String test2(User user) {
//		return user.toString();
//	}
	
	// JSON 형태로 값을 보내면 저기 user라고 하는 바구니에 넣어버리고 싶어!!
	/* {
	  "name": "boyeon",
	  "id" : "ssafy",
	  "password" : "1234"
	} */
	// @RequestBody : 붙이면 JSON 데이터를 원하는 타입으로 바인딩 시켜준다
	@PostMapping("/board")
	public String test3(@RequestBody User user) {
		return user.toString();
	}
	
	// ResponseEntity : 응답하려고 하는 데이터 / 응답 상태코드 / 응답 헤더 같은 것을 결정할 수 있음
	@GetMapping("/test4")
	public ResponseEntity<String> test4(){
		// 헤더를 조작하기 위해 HttpHeaders 사용
		HttpHeaders headers = new HttpHeaders();
		headers.add("auth", "admin");
		
		// CREATE => 등록 OK
		return new ResponseEntity<String>("OK", headers, HttpStatus.CREATED);
	}
	
}
