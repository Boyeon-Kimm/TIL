package com.ssafy.board.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	private static final String SALT = "SSAFIT";

	// 토큰 생성
	// createToken 하는데 인자로 키와 밸류가 넘어왔다고만 처리, JWT에 데이터를 하나만 받아올 땐 가능(한 가지의 정보만 넣는다고 가정)
	// 여러 개를 받아올 때는 여러개의 데이터를 받을 수 있는 바구니 준비하여 처리해야함
	public String createToken(String claimId, String data) throws UnsupportedEncodingException {
		// 테스트하는데 잠시 방해가 되는 유효기간은 지운다...
		return Jwts.builder()
				.setHeaderParam("alg", "HS256")
				.setHeaderParam("typ", "JWT") // 헤더 완료
				.claim(claimId, data)
				.signWith(SignatureAlgorithm.HS256, "SSAFIT".getBytes("UTF-8")) // 디지털 서명 완료
				.compact();
	}

	// 유효성 검사
	public void valid(String token) throws Exception {
		Jwts.parser().setSigningKey("SSAFIT".getBytes("UTF-8")).parseClaimsJws(token);
	}
}
