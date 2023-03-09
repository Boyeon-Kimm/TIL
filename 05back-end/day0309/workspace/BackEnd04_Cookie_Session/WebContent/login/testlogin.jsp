<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("password");
	
	if(id.equals("ssafy") && pw.equals("1234")){
		// 로그인 성공(세션에 데이터를 넣자)
		// 세션을 얻어오자
		// HttpSession session = request.getSession();
		session.setAttribute("loginUser", id);
		response.sendRedirect("main.jsp");
	} else {
		// 로그인 실패(다시 로그인 폼으로 보내버려)
		response.sendRedirect("loginForm.jsp");
	}

%>