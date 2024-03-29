<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>영상 리뷰 관리 사이트</title>
	<!-- Favicon-->
	<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
	<!-- Google fonts-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
	<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
	<link href="https://cdn.rawgit.com/moonspam/NanumSquare/master/nanumsquare.css" rel="stylesheet" type="text/css" >
	<!-- Core theme CSS (includes Bootstrap)-->
	<link href="css/styles.css" rel="stylesheet" />
</head>

<body id="page-top">
	<!-- Navigation-->
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
					<li class="nav-item"><a class="nav-link" href="main?act=index">Main</a></li>
					<li class="nav-item"><a class="nav-link" href="main?act=loginpage">Login</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<section class="page-section" id="contact">
		<div class="container">
			<div class="text-center">
				<br><br><br>
				<h2 class="section-heading text-uppercase">회원가입</h2>
				<h3 class="section-subheading text-muted">SSAFIT에 오신 것을 환영합니다!</h3>
			</div>
			<form id="contactForm" data-sb-form-api-token="API_TOKEN">
				<div class="row align-items-stretch mb-5">
					<div class="col-md-6">
						<div class="form-group">
							<!-- Id input-->
							<input class="form-control" id="id" type="text" placeholder="아이디"
								data-sb-validations="required" />
							<div class="invalid-feedback" data-sb-feedback="name:required">아이디를 입력해주세요.</div>
						</div>
						<div class="form-group">
							<!-- Password input-->
							<input class="form-control" id="password" type="password" placeholder="비밀번호"
								data-sb-validations="required,password" />
							<div class="invalid-feedback" data-sb-feedback="password:required">비밀번호를 입력해주세요.</div>
							<div class="invalid-feedback" data-sb-feedback="password:password">비밀번호 형식이 올바르지 않습니다.</div>
						</div>
						<div class="form-group">
							<!-- Name input-->
							<input class="form-control" id="name" type="text" placeholder="이름"
								data-sb-validations="required" />
							<div class="invalid-feedback" data-sb-feedback="name:required">이름을 입력해주세요.</div>
						</div>
						<div class="form-group">
							<!-- Email address input-->
							<input class="form-control" id="email" type="email" placeholder="이메일 주소"
								data-sb-validations="required,email" />
							<div class="invalid-feedback" data-sb-feedback="email:required">이메일을 입력해주세요.</div>
							<div class="invalid-feedback" data-sb-feedback="email:email">이메일주소 형식이 올바르지 않습니다.</div>
						</div>
						<div class="form-group mb-md-0">
							<!-- Phone number input-->
							<input class="form-control" id="phone" type="text" placeholder="휴대폰 번호"
								data-sb-validations="required" />
							<div class="invalid-feedback" data-sb-feedback="phone:required">휴대폰 번호를 입력해주세요.</div>
						</div>
					</div>
				</div>
				<!-- register Button-->
				<div class="loginBtn">
					<button class="btn btn-primary btn-xl text-uppercase" onclick="regist()"
						type="button">회원 등록</button>
					<button class="btn btn-primary btn-xl text-uppercase" onclick="location.href='login.html'"
						type="button">취소</button>
					</div>
			</form>
		</div>
	</section>
	<footer class="footer py-4">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-4 text-lg-start">Copyright &copy; SSAFY</div>
				<div class="col-lg-4 my-3 my-lg-0">
					<a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Twitter"><i class="fab fa-twitter"></i></a>
					<a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Facebook"><i class="fab fa-facebook-f"></i></a>
					<a class="btn btn-dark btn-social mx-2" href="#!" aria-label="LinkedIn"><i class="fab fa-linkedin-in"></i></a>
				</div>
				<div class="col-lg-4 text-lg-end">
					<a class="link-dark text-decoration-none me-3" href="#!">개인정보 처리방침</a>
					<a class="link-dark text-decoration-none me-3" href="#!">이용약관</a>
					<a class="link-dark text-decoration-none" href="#!">오시는 길</a>
				</div>
			</div>
		</div>
	</footer>
	<script type="text/javascript" src="js/scripts.js"></script>
	<!-- Bootstrap core JS-->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
	<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>

</html>