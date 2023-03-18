<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Write Review</title>
	<style>
		.writearea{
			display: flex;
			flex-direction: column	;
			justify-content: center;
			align-items: center;
			min-height: 100vh;
			margin-top: -25px;
		}
		.review{
			display: flex;
			flex-direction: column;			
			min-height: 100vh;
			justify-content: center;
			align-items: center;
		}

		.mb-3{
			width:80%;
		}

		h5{
			text-align:center;      
		}

    form{
      width:100%;
      display: flex;
			flex-direction: column;		
			justify-content: center;
			align-items: center;
    }

    strong{
      font-size: 120%;
    }
	</style>
	<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
	<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
	<link href="https://cdn.rawgit.com/moonspam/NanumSquare/master/nanumsquare.css" rel="stylesheet" type="text/css" >
	<link href="css/styles.css" rel="stylesheet" />
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="main?act=index"><h3>SSAFIT</h3></a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
				Menu
				<i class="fas fa-bars ms-1"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
					<li class="nav-item"><a class="nav-link" href="#services">Top3</a></li>
					<li class="nav-item"><a class="nav-link" href="#portfolio">View All</a></li>
					<li class="nav-item"><a class="nav-link" href="#team">Team</a></li>
					<li class="nav-item"><a class="nav-link" href="main?act=loginpage">Login</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="review">
		<h3>리뷰 작성 하기</h3>
		<br><br><br>
		<form action="main" method="POST">
      <input type="hidden" name="act" value="write">
      <input type="hidden" name="videoId" value="${video.youtubeId}">
      <b>영상 제목</b><br>
      <strong>${video.title }</strong><br>
			<div class="mb-3">
				<label for="writer" class="form-label">작성자</label>
				<input type="text" class="form-control" id="writer" name="writer" placeholder="제목을 입력하세요">
			</div>
			<div class="mb-3">
				<label for="content" class="form-label">내용</label>
				<textarea class="form-control" id="content" name="content" placeholder="내용을 입력하세요"></textarea>
			</div>
			<div class="submits">			
        		<button class="btn btn-primary btn-xl text-uppercase" >등록하기</button>
			</div>
		</form>
	</div>
</body>
</html>