package com.ssafy.board.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyAppSqlConfig {
	private static SqlSession session;
	
	static {
		//MyBatis 설정파일을 가져오겠다.
		try {
			String resource = "config/mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			//공장도 다 세웠다.
			
			//세션 팩토리르 이용해서 세션을 얻어오겠다.
			session = sqlSessionFactory.openSession(true); //true라는 옵션을 주면 자동으로 커밋이된다.
			System.out.println("세션 생성 성공");
		} catch (IOException e) {
			System.out.println("세션 생성 실패");
		}
	}
	
	public static SqlSession getSession() {
		return session;
	}
	
}
