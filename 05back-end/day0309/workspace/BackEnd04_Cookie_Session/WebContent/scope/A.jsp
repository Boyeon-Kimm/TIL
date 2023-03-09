<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		pageContext.setAttribute("name", "page kim");
		request.setAttribute("name", "request kim");
		session.setAttribute("name", "session kim");
		application.setAttribute("name", "application kim");
		
		System.out.println("A.jsp");
		System.out.println("페이지 속성 " + pageContext.getAttribute("name"));
		System.out.println("요청 속성 "+ request.getAttribute("name"));
		System.out.println("세션 속성 "+ session.getAttribute("name"));
		System.out.println("어플리케이션 속성 "+ application.getAttribute("name"));
		
		request.getRequestDispatcher("B.jsp").forward(request, response);
		
	%>
	
	
</body>
</html>