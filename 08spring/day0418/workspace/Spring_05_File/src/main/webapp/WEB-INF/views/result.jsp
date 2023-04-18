<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과창</title>
</head>
<body>
	<a href="/mvc/upload/${fileName }">${fileName }</a>
	<!-- 컨택스트 루트를 직접 적는건 굉장히 별로... -->
	<img src="${pageContext.request.contextPath}/upload/${fileName }"/>
	<!-- 다운로드를 하기 위해서 a href태그를 이용하여 다시 한 번 요청을 보낼 것임-->
	<!-- download경로로 요청을 보낼 것인데 filename을 파라미터로 실어서 같이 보낼 것임 -->
	<a href="download?fileName=${fileName }">${fileName }다운로드</a>
	
<%-- 	<c:foreach items="${list }" var="fileName"> --%>
<%-- 		${fileName } <br> --%>
<%-- 	</c:foreach> --%>
</body>
</html>