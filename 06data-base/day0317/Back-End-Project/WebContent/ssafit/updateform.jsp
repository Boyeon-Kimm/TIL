<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update review</title>
<style>
  .update{
    display: flex;
    padding-top: 10%;
    flex-direction: column;
    justify-content: center;
    align-items: center;
	  min-height: 100vh;
    
   }
  .videoplayer {
  position: relative;
  width: 60%;
  padding-bottom: 33.75%; /* 16:9 비율 */
  }
  iframe {
  position: absolute;
  width: 100%; /* 부모에 맞게 꽉 채운다. */
  height: 100%;
  }
  h5,button,strong{
  text-align:center;
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
  <div class="update">
		<h3>리뷰 수정 하기</h3>
		<br><br><br>
		<form action="main" method="POST">
      <input type="hidden" name="act" value="update">
      <input type="hidden" name="videoId" value="${video.youtubeId}">
      <input type="hidden" name="reviewIdx" value="${review.idx}">
      <strong>영상 제목<strong>
      <p>${video.title }</p>
			<div class="mb-3">
				<label for="writer" class="form-label">작성자</label>
        <br>
        ${review.writer}
			</div>
			<div class="mb-3">
				<label for="content" class="form-label">내용</label>
				<textarea class="form-control" id="content" name="content">${review.content }</textarea>
			</div>
			<div class="submits">			
        		<button class="btn btn-primary btn-xl text-uppercase" >수정하기</button>
			</div>
		</form>
	</div>