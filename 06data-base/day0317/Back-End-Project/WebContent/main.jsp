<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SSAFIT : MAIN</title>    
    <style>
        .container{
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        
        .title{            
            text-align: center;
        }

        a{
            size : 20%;
        }
    </style>
	<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
	<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
	<link href="https://cdn.rawgit.com/moonspam/NanumSquare/master/nanumsquare.css" rel="stylesheet" type="text/css" >
	<link href="css/styles.css" rel="stylesheet" />
</head>
<body>
    <div class="container">
        <h1 class="title">SSAFIT에 오신 것을 환영합니다!</h1>
        <br><br><br><br><br><br>
        <a href="main?act=index" class="btn btn-primary btn-xl text-uppercase">SSAFIT 입장하기</a>
    </div>
</body>
</html>
