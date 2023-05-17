package com.ssafy.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.board.util.JwtUtil;

@Component
public class JwtInterceptor implements HandlerInterceptor{
	private static final String HEADER_AUTH = "access-token";
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 브라우저에서 이러한 요청이 있으면 먼저 한 번 검증을 하기위해서 던져보는 것
		// getMethod에 OPTION이라는 게 있음. OPTION이라면 그냥 진행시켜
		// 나머지는 검사 진행해 !
		if(request.getMethod().equals("OPTIONS"))
			return true;
		
		// 요청에서 헤더부분에 실어서 보낼거야
		// 헤더를 가져와서 access-token이라는 것을 가져와서
		// 헤더를 뒤져서 access-token이름을 가진 친구가 있다면 가지고 와
		String token = request.getHeader(HEADER_AUTH);
		
		if(token != null) {
			jwtUtil.valid(token); // 유효성 검사, 터졌다면 알아서 예외처리 됨.
			return true; // 진행시켜
		}
		
		throw new Exception("유효하지 않은 접근이다.");
		
	}
}
