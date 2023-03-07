package com.ssafy.myservlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 해당 클래스를 서블릿으로 만들기 위해서
// Servlet(인터페이스) 이라는 것을 구현해야한다.

public class MyServlet1 implements Servlet{

	@Override
	public void destroy() {
		// 서블릿이 파괴될 때
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// 무엇인가 서블릿 설정같은 것을 건들이는 것 같다
		return null;
	}

	@Override
	public String getServletInfo() {
		// 서블릿 정보
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// 서블릿 초기화 할 때
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// 클라이언트로부터 요청이 들어왔다면 처리를 하는 부분
		
	}
	
}
