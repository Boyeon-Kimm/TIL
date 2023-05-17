package com.ssafy.board.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.User;
import com.ssafy.board.util.JwtUtil;

@RestController
@RequestMapping("/api")
public class UserRestController {

	// createToken을 사용하기 위해 JwtUtil을 가지고 온다
	// 스프링 컨테이너한테 너가 가지고 있는 JwtUtil 중에 하나 넣어줘!
	@Autowired
	private JwtUtil jwtUtil;

	private static final String SUCCESS = "succes";
	private static final String FAIL = "fail";

	// 로그인
	// User라는 것을 통해서 Vue에서 axios요청을 통해서 User에 데이터가 들어올 것임
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(User user){
		Map<String, Object> result = new HashMap<String, Object>();
		
		// user를 이용해서 Service -> Dao -> DB를 통해 실제 유저인지 확인을 해야한다
		// 아이디가 null이 아니거나 길이가 있거나
		HttpStatus status = null;
		
		try {
			if(user.getId() != null || user.getId().length() > 0) {
				// 토큰이름은 access-token이라고 할 것임. 이름 아무거나해도 상관 없다
				result.put("access-token", jwtUtil.createToken("id", user.getId()));
				result.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				result.put("message", FAIL);
				status = HttpStatus.NO_CONTENT;
			}
		} catch (UnsupportedEncodingException e) {
			result.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		// ResponseEntity를 이용해서 내가 가지고 있는 result와 status 값을 보낸다.
		return new ResponseEntity<Map<String, Object>>(result, status);
	
	}
}