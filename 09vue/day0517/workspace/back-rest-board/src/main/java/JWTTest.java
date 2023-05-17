import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTTest {
	public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
		String token = 
				
				Jwts.builder()
				.setHeaderParam("alg", "HS256")
				.setHeaderParam("typ", "JWT") // 헤더 완료
				.claim("userId", "ssafy")
				.setExpiration(new Date(System.currentTimeMillis() + 3000)) // 3초, payload 완료
				// HS256방식 암호 알고리즘 사용, SSAFIT이라는 문자열을 바이트 방식으로 바꾼 시크릿 키
				.signWith(SignatureAlgorithm.HS256, "SSAFIT".getBytes("UTF-8")) // 디지털 서명 완료
				// String type으로 반환을 해주겠다.
				.compact();
		
		System.out.println(token);
		// 문자열 객체 생성, base64 방식으로 디코더 하나를 가져올 것임
		// .을 기준으로 쪼갠 후 1번째 문자열을 확인할 것이다
		System.out.println(new String(Base64.getDecoder().decode(token.split("\\.")[1])));
		
		// 위에서 설정한 유효기간이 3초이므로 3초 뒤에 다시 한 번 검사를 해보면 오류가 뜨는걸 확인해보자...
		Thread.sleep(4000);
		
		// 유효성 검사
		// JWT가 가지고 있는 parser을 이용
		// 사이닝키를 이용해서 claim을 가지고 온다
		Jws<Claims> claims = Jwts.parser().setSigningKey("SSAFIT".getBytes("UTF-8")).parseClaimsJws(token);
		System.out.println(claims);
	}
}
