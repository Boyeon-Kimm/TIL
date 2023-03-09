<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 로그아웃을 하는 방법으로는 2가지 -->
	
	<% session.removeAttribute("loginUser"); %>
	
<%-- 	<% session.invalidate(); %> --%>
	
	<script type="text/javascript">
		alert("로그아웃 완료.");
		location.href="loginForm.jsp";
	</script>
</body>
</html>