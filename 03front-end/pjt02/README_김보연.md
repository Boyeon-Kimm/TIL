## SSAFIT Project02 : Web Front PJT

<br>
<br>

### 👩‍💻 팀 소개

- 팀명 : Coffee
- 팀원 : 서울 8반 김보연, 송채은
- 진행일 : 2023년 2월 10일
- 개발환경 및 도구 : Windows 10, Visual Studio Code

<br>
<br>

### ✔️ 프로젝트 목표

- 과정에서 배운 Web Front 기술인 HTML / CSS / Javascript를 이해하고 활용할 수 있다.
- CSS, Bootstrap을 활용해서 향상된 디자인을 구현할 수 있다.
- Ajax를 활용하여 사이트를 구축할 수 있다.
- UX(사용자 경험), UI(사용자 인터페이스)를 고려한 사이트를 구현하여 사용자 입장에서 편리하고 멋진 디자인을 설계해본다.

<br>
<br>

### ✔️ 요구사항

- Wireframe Tool을 이용하여 구현할 웹 페이지 프로토타입을 설계해 본다.
- 웹페이지 구현시 VSCode를 이용하여 구현한다.
- 기능 구현
    - 기본기능 : 다양한 운동영상정보와 영상의 리뷰와 관련된 페이지를 제공한다.
        - 메인페이지 구성
            - 운동영상 정보의 다양한 화면 구성(최근 인기영상, 운동 부위별 영상 등)
            - 메인페이지의 영상화면은 제공된 Ajax를 이용(json 데이터 파일 로딩)
        - 메뉴 구성
            - 사이트의 주요 메뉴를 구성
        - 운동 영상에 대한 리뷰 관리 페이지 구성
            - 목록, 등록, 수정, 상세, 삭제
    - 추가기능 : 사이트의 다양한 기능을 사용하기 위해서 회원가입, 로그인 페이지를 제공한다.
        - 회원가입 페이지
        - 로그인 페이지
    - 심화기능 : 관심있는 영상에 대한 찜 관리 페이지와 회원간 팔로우 페이지를 제공한다. 회원은 다른 회원을 팔로우 할 수 있다.
        - 회원 간 팔로우 관리 페이지
        - 회원의 운동영상 찜 관리 페이지

		<br>
		<br>

### ✔️ 전체 코드

### ➕ `폴더 구조`

```
📂 css
	ㄴ**#** style.css
📂 data
	ㄴ🖼️ background1.jpg
	ㄴ🖼️ img1.png
	ㄴ🖼️ img2.jpg
	ㄴ🖼️ main2.jpg
	ㄴ**{}** video.json
📂 js
	ㄴ**JS** scripts.js
**<>** index.html
**<>** login.html
**<>** register.html
```
<br>

### ➕ `index.html`

```html
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>영상 리뷰 관리 사이트</title>
	<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
	<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
	<link href="https://cdn.rawgit.com/moonspam/NanumSquare/master/nanumsquare.css" rel="stylesheet" type="text/css" >
	<link href="css/styles.css" rel="stylesheet" />
</head>

<body id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="index.html"><h3>SSAFIT</h3></a>
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
					<li class="nav-item"><a class="nav-link" href="login.html">Login</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Masthead-->
	<header class="masthead">
		<div class="container">
			<div class="masthead-subheading">Welcome To Our Site!</div>
			<div class="masthead-heading text-uppercase">Let's workout everyday!</div>
			<a class="btn btn-primary btn-xl text-uppercase" href="#services">View More</a>
		</div>
	</header>
	<!-- 인기 영상 TOP3 -->
	<section class="page-section" id="services">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase">인기 영상 TOP3</h2><hr>
				<h3 class="section-subheading text-muted">최근 7일간 가장 많이 본 영상</h3>
			</div>
			<div class="row row-cols-1 row-cols-md-3 g-4">
				<div class="col">
					<div class="card h-100">
						<img src="https://img.youtube.com/vi/54tTYO-vU2E/mqdefault.jpg" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title">상체 TOP1</h5>
							<p id="upper"></p>
							<button type="button" class="btn btn-warning" onclick="window.open('https://www.youtube.com/embed/54tTYO-vU2E')">영상보러가기</button>
							<button type="button" class="btn btn-warning">찜</button>
						</div>
						<div class="card-footer">
							<small class="text-muted">Last updated 5 days ago</small>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card h-100">
						<img src="https://img.youtube.com/vi/u5OgcZdNbMo/mqdefault.jpg" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title">하체 TOP1</h5>
							<p id="lower"></p>
							<button type="button" class="btn btn-warning" onclick="window.open('https://www.youtube.com/embed/u5OgcZdNbMo')">영상보러가기</button>
							<button type="button" class="btn btn-warning">찜</button>
						</div>
						<div class="card-footer">
							<small class="text-muted">Last updated 3 months ago</small>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card h-100">
						<img src="https://img.youtube.com/vi/gMaB-fG4u4g/mqdefault.jpg" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title">전신 TOP1</h5>
							<p id="full"></p>
							<button type="button" class="btn btn-warning" onclick="window.open('https://www.youtube.com/embed/gMaB-fG4u4g')">영상보러가기</button>
							<button type="button" class="btn btn-warning">찜</button>
						</div>
						<div class="card-footer">
							<small class="text-muted">Last updated 2 weeks ago</small>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- 운동 영상 리스트 -->
	<section class="page-section bg-light" id="portfolio">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase">전체 영상 보기</h2>
				<hr>
			</div>
			<br>
			<div class="row content-video-list">
				<!-- js 파일에서 json 파일에 등록된 8개 영상 목록이 이 부분에 출력됨 -->
			</div>
		</div>
	</section>
	<!-- Team -->
	<section class="page-section bg-light" id="team">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase">Our Amazing Team</h2>
				<h3 class="section-subheading text-muted">Team Coffee</h3>
			</div>
			<div class="row">
				<div class="col-lg-4">
					<div class="team-member">
						<img class="mx-auto rounded-circle" src="data/img1.png" alt="..." />
						<h4>김보연</h4>
						<p class="text-muted">SSAFY 9기 서울8반</p>
						<a class="btn btn-dark btn-social mx-2" href="https://github.com/Boyeon-Kimm" aria-label="Parveen Anand Twitter Profile"><i 
								class="fab fa-github"></i></a>
						<a class="btn btn-dark btn-social mx-2" href="mailto:kkbbyy1113@gmail.com" aria-label="Parveen Anand Facebook Profile"><i
								class="fas fa-envelope"></i></a>
						<a class="btn btn-dark btn-social mx-2" href="https://www.instagram.com/__ml.o_o.lm__" aria-label="Parveen Anand LinkedIn Profile"><i
								class="fab fa-instagram"></i></a>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="team-member">
						<img class="mx-auto rounded-circle" src="data/img2.jpg" alt="..." />
						<h4>송채은</h4>
						<p class="text-muted">SSAFY 9기 서울8반</p>
						<a class="btn btn-dark btn-social mx-2" href="https://github.com/SongChaee" aria-label="Diana Petersen Twitter Profile"><i
								class="fab fa-github"></i></a>
						<a class="btn btn-dark btn-social mx-2" href="mailto:sce9842@gmail.com" aria-label="Diana Petersen Facebook Profile"><i
								class="fas fa-envelope"></i></a>
						<a class="btn btn-dark btn-social mx-2" href="https://www.instagram.com/song_sangsung" aria-label="Diana Petersen LinkedIn Profile"><i
								class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-8 mx-auto text-center">
					<p class="large text-muted">Samsung Software Academy For Youth</p>
				</div>
			</div>
		</div>
	</section>
	<!-- Footer-->
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
	<!-- 운동 영상 Modals-->
	<div class="modal-list">
		<!-- js파일에서 각 운동영상의 modal 설정 -->
	</div>

	<script>
		function getJSON(){
			
		}
	</script>
	<!-- Bootstrap core JS-->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
	<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>

</html>
```

<br>

### ➕ `login.html`

```html
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
			<a class="navbar-brand" href="index.html"><h3>SSAFIT</h3></a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
				Menu
				<i class="fas fa-bars ms-1"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
					<li class="nav-item"><a class="nav-link" href="index.html">Main</a></li>
					<li class="nav-item"><a class="nav-link" href="login.html">Login</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<section class="page-section" id="contact">
		<div class="container">
			<div class="text-center">
        <br><br><br>
				<h2 class="section-heading text-uppercase">로그인</h2>
				<h3 class="section-subheading text-muted">SSAFIT에 오신 것을 환영합니다!</h3>
			</div>
			<form id="contactForm" data-sb-form-api-token="API_TOKEN">
				<div class="row align-items-stretch mb-5">
					<div class="col-md-6">
						<div class="form-group">
							<!-- Email address input-->
							<input class="form-control" id="id" type="id" placeholder="아이디"
								data-sb-validations="required,id" />
							<div class="invalid-feedback" data-sb-feedback="id:required">아이디를 입력해주세요.</div>
						</div>
						<div class="form-group mb-md-0">
							<!-- Password input-->
							<input class="form-control" id="password" type="password" placeholder="비밀번호"
								data-sb-validations="required,password" />
							<div class="invalid-feedback" data-sb-feedback="password:required">비밀번호를 입력해주세요.</div>
							<div class="invalid-feedback" data-sb-feedback="password:password">비밀번호 형식이 올바르지 않습니다.</div>
						</div>
					</div>
				</div>
        <div class="loginBtn">
					<!-- login / joinin button -->
					<button type="button" class="btn btn-primary btn-xl text-uppercase" onclick="login()">로그인</button>
         	<button type="button" class="btn btn-primary btn-xl text-uppercase" onclick="location.href='register.html'">회원가입</button>
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
					<a class="link-dark text-decoration-none me-3" href="#!">이용약관 </a>
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
```

<br>

### ➕ `register.html`

```html
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
			<a class="navbar-brand" href="index.html"><h3>SSAFIT</h3></a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
				Menu
				<i class="fas fa-bars ms-1"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
					<li class="nav-item"><a class="nav-link" href="index.html">Main</a></li>
					<li class="nav-item"><a class="nav-link" href="login.html">Login</a></li>
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
```

<br>

### ➕ `styles.css`

```css
파일 참조 ... 너무 긴 관계로..
```

<br>

### ➕ `scripts.js`

```jsx
/*!
* Start Bootstrap - Agency v7.0.11 (https://startbootstrap.com/theme/agency)
* Copyright 2013-2022 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-agency/blob/master/LICENSE)
*/

// navbar 설정
window.addEventListener('DOMContentLoaded', event => {

	// Navbar shrink function
	var navbarShrink = function () {
		const navbarCollapsible = document.body.querySelector('#mainNav');
		if (!navbarCollapsible) {
			return;
		}
		navbarCollapsible.classList.add('navbar-shrink')
	};

	// Shrink the navbar 
	navbarShrink();

	// Shrink the navbar when page is scrolled
	document.addEventListener('scroll', navbarShrink);

	// Activate Bootstrap scrollspy on the main nav element
	const mainNav = document.body.querySelector('#mainNav');
	if (mainNav) {
		new bootstrap.ScrollSpy(document.body, {
			target: '#mainNav',
			offset: 74,
		});
	};

	// Collapse responsive navbar when toggler is visible
	const navbarToggler = document.body.querySelector('.navbar-toggler');
	const responsiveNavItems = [].slice.call(
		document.querySelectorAll('#navbarResponsive .nav-link')
	);
	responsiveNavItems.map(function (responsiveNavItem) {
		responsiveNavItem.addEventListener('click', () => {
			if (window.getComputedStyle(navbarToggler).display !== 'none') {
				navbarToggler.click();
			}
		});
	});

});

// 운동 영상 목록 관련 변수
// videolist : 제목, 채널명 등 정보가 담긴 객체 배열
let videos;
let videolist;

// onload와 동시에 json 파일 읽어오기
window.onload = function(){

	// ajax 를 위한 xmlhttprequest 객체 생성
	const xhr = new XMLHttpRequest();
	// GET 방식
	const method = "GET";
	// json 파일 위치
	const url = "data/video.json";
	// 요청 초기화
	xhr.open(method, url);
	// 헤더 정보 초기화
	xhr.setRequestHeader("Content-Type", "application/text");
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState === xhr.DONE) {
		  if (xhr.status === 200) {
			videos = JSON.parse(xhr.responseText);
			localStorage.setItem("videos", JSON.stringify(videos));
			videolist = JSON.parse(localStorage.getItem("videos"));
			//console.log(videolist);

			let upperTitle = document.getElementById("upper");
			upperTitle.innerText = videolist[2].title;
			let lowerTitle = document.getElementById("lower");
			lowerTitle.innerText = videolist[5].title;
			let fullTitle = document.getElementById("full");
			fullTitle.innerText = videolist[0].title;

			// 전체 운동 영상 목록에서 modal 추가를 위한 부분
			let videoArea = document.querySelector(".content-video-list");
			for(let i = 0; i < videolist.length; i++){
				let srcurl = "https://img.youtube.com/vi/" + videolist[i].id + "/0.jpg";
				let modalhref = "#videomodal" + i;
				let videoItem = `
					<div class="col-lg-4 col-sm-6 mb-4">
						<div class="portfolio-item">
							<a class="portfolio-link" data-bs-toggle="modal" href="${modalhref}">
								<div class="portfolio-hover">
									<div class="portfolio-hover-content"><i class="fas fa-plus fa-3x"></i></div>
								</div>
								<img class="img-fluid" src="${srcurl}" alt="..." />
							</a>
							<div class="portfolio-caption">
								<div class="portfolio-caption-heading">${videolist[i]["title"]}</div>
								<div class="portfolio-caption-subheading text-muted">${videolist[i]["channelName"]}</div>
							</div>
						</div>
					</div>
				`;
				videoArea.innerHTML += videoItem;
			}

			// localStorage에 저장된 리뷰가 있다면 추가해서 보여주기 위한 부분
			let modalList = document.querySelector(".modal-list");
			for(let i = 0; i < videolist.length; i++){
				let title = videolist[i].title;
				let channelName = videolist[i].channelName;
				let url = videolist[i].url;
				let reviewclassname = "review-list-" + i;
				let funcname = "reviewRegist" + i;
				let nameid = "nickname" + i;
				let contentid = "content" + i;
				let modalid = "videomodal" + i;
				let modal2id = "videomodal2" + i;

				let localkeyname = "review" + i;

				let modalItem = `
				<div class="portfolio-modal modal fade" id="${modalid}" tabindex="-1" role="dialog" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="close-modal" data-bs-dismiss="modal"><img src="assets/img/close-icon.svg" alt="Close modal" /></div>
							<div class="container">
								<div class="row justify-content-center">
									<div class="col-lg-8">
										<div class="modal-body">
											<h3 class="text-uppercase">${title}</h3>
											<p class="item-intro text-muted">${channelName}</p>
											<iframe src="${url}"></iframe>
											<p></p>
											<ul class="review-list">
												<h5>영상 리뷰</h5>
												<div class="${reviewclassname}">`;
				
				if(localStorage.getItem(localkeyname) != null){
					let localreview = localStorage.getItem(localkeyname);
					localreview = "[" + localreview.replace(/}{/g, "},{") + "]";
					let reviewlist = JSON.parse(localreview);
					if(reviewlist.length > 0){
						for(let r = 0; r < reviewlist.length; r++){
							modalItem += `
								<li>
									<strong>${reviewlist[r].name}</strong>
									${reviewlist[r].content}
								</li>
							`;
						}
					} else{
				
					}
				} else{
					modalItem += `
							<li>
								<strong>등록된 리뷰가 없습니다</strong>
							</li>
						`;
				}

				// 리뷰 목록 이후 부분
					modalItem += `
												</div>
											</ul>
											<button class="btn btn-primary btn-xl text-uppercase" type="button" data-bs-target="#${modal2id}" data-bs-toggle="modal">
												리뷰 등록
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="portfolio-modal modal fade" id="${modal2id}" aria-hidden="true" aria-labelledby="exampleModalToggleLabel2" tabindex="-1">
					<div class="modal-dialog modal-dialog-centered">
						<div class="modal-content">
							<div class="modal-header">
								<h1 class="modal-title fs-5">리뷰 등록</h1>
								<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							</div>
							<form>
								<div class="modal-body">
									<div class="form-group">
										<input id="${nameid}" class="form-control" type="text" placeholder="닉네임" data-sb-validations="required"/>
										<div class="invalid-feedback" data-sb-feedback="name:required">닉네임을 입력하세요</div>
									</div>
									<br>
									<div class="form-group">
										<input id="${contentid}" class="form-control" type="text" placeholder="내용" data-sb-validations="required"/>
										<div class="invalid-feedback" data-sb-feedback="name:required">리뷰 내용을 입력하세요</div>
									</div>
								</div>
							<div class="modal-footer">
								<button class="btn btn-primary" data-bs-target="#${modalid}" type="button" data-bs-toggle="modal" onclick="${funcname}()">저장</button>
							</div>
							</form>
						</div>
					</div>
				</div>
				`;
				modalList.innerHTML += modalItem;
			}

			}
		}
	};
	xhr.send();
};

// 회원 가입
function regist() {
  // 문서에서 id 로 input data 가져오기
  let id = document.getElementById("id").value;
  let password = document.getElementById("password").value;
  let name = document.getElementById("name").value;
  let email = document.getElementById("email").value;
  let phone = document.getElementById("phone").value;

  // 입력값 검증
  if (!id || !password || !name || !email || !phone ) {
    alert("빈칸이 없도록 입력해주세요.");
    return;
  } else {
    // input data로 user 만들기
    const user = {
      id: id,
      password: password,
      name: name,
      email: email,
      phone: phone,
    };

		// user 객체 문자열로 바꿔서 로컬스토리지에 저장
		let update;
		if(localStorage.getItem("user") === null) {
			update = JSON.stringify(user);
		} else{
			let pre = localStorage.getItem("user");
			update = pre + JSON.stringify(user);
		}
    localStorage.setItem("user", update);
    alert("회원가입이 완료되었습니다!");
    // 로그인 화면으로 돌아가기
    location.replace("login.html");
  }
}

// 로그인
function login() {
  // 문서에서 id로 input data 가져오기
  let id = document.getElementById("id").value;
  let password = document.getElementById("password").value;

  // 로컬스토리지에 "user" 키로 저장된 item 가져와서 json 객체로 만들기
  //const user = JSON.parse(localStorage.getItem("user"));
	let userStr = localStorage.getItem("user");
	userStr = "[" + userStr.replace(/}{/g, "},{") + "]";
	let userlist = JSON.parse(userStr);
	
	let success = false;
  // 입력값 검증
	for(let i = 0; i < userlist.length; i++){
		if(userlist[i].id === id && userlist[i].password === password){
			alert(userlist[i].name + "님 로그인 성공 !");
			success = true;
    	// 로그인 성공하면 index 페이지로 이동.
    	location.replace("index.html");
			break;
		}
	}
	if(success === false)
		alert("로그인 실패 !");
}

// 리뷰 저장 후 리뷰 목록 출력
// 영상별 리뷰 목록을 localStorage에 저장할 때 key 값을 다르게 하기 위함
function reviewRegist0() {
	let name = document.getElementById("nickname0").value;
	let content = document.getElementById("content0").value;

	if(!name || !content){
		alert("빈 칸이 없도록 입력해주세요.")
		return;
	} else{
		const review = {
			name: name,
			content: content,
		};
		
		let update;
		if(localStorage.getItem("review0") === null){
			update = JSON.stringify(review);
		} else{
			let pre = localStorage.getItem("review0");
			update = pre + JSON.stringify(review);
		}
		
		localStorage.setItem("review0", update);
		let localreview = localStorage.getItem("review0");
		localreview = "[" + localreview.replace(/}{/g, "},{") + "]";
		alert("리뷰 등록 완료");

		let reviewArea = document.querySelector(".review-list-0")
		let reviewlist = JSON.parse(localreview);
		let modalItem = ``;
		if(reviewlist.length > 0){
			for(let r = 0; r < reviewlist.length; r++){
				modalItem += `
					<li>
						<strong>${reviewlist[r].name}</strong>
						${reviewlist[r].content}
					</li>
				`;
			}
		} else{
			modalItem += `
				<li>
					<strong>등록된 리뷰가 없습니다</strong>
				</li>
			`;
		}
		reviewArea.innerHTML = modalItem;
	}
}

function reviewRegist1() {
	let name = document.getElementById("nickname1").value;
	let content = document.getElementById("content1").value;

	if(!name || !content){
		alert("빈 칸이 없도록 입력해주세요.")
		return;
	} else{
		const review = {
			name: name,
			content: content,
		};
		
		let update;
		if(localStorage.getItem("review1") === null){
			update = JSON.stringify(review);
		} else{
			let pre = localStorage.getItem("review1");
			update = pre + JSON.stringify(review);
		}
		
		localStorage.setItem("review1", update);
		let localreview = localStorage.getItem("review1");
		localreview = "[" + localreview.replace(/}{/g, "},{") + "]";
		alert("리뷰 등록 완료");
		console.log(localreview);

		let reviewArea = document.querySelector(".review-list-1")
		let reviewlist = JSON.parse(localreview);
		let modalItem = ``;
		if(reviewlist.length > 0){
			for(let r = 0; r < reviewlist.length; r++){
				modalItem += `
					<li>
						<strong>${reviewlist[r].name}</strong>
						${reviewlist[r].content}
					</li>
				`;
			}
		} else{
			
		}
		reviewArea.innerHTML = modalItem;
	}
}

function reviewRegist2() {
	let name = document.getElementById("nickname2").value;
	let content = document.getElementById("content2").value;

	if(!name || !content){
		alert("빈 칸이 없도록 입력해주세요.")
		return;
	} else{
		const review = {
			name: name,
			content: content,
		};
		
		let update;
		if(localStorage.getItem("review2") === null){
			update = JSON.stringify(review);
		} else{
			let pre = localStorage.getItem("review2");
			update = pre + JSON.stringify(review);
		}
		
		localStorage.setItem("review2", update);
		let localreview = localStorage.getItem("review2");
		localreview = "[" + localreview.replace(/}{/g, "},{") + "]";
		alert("리뷰 등록 완료");
		console.log(localreview);

		let reviewArea = document.querySelector(".review-list-2")
		let reviewlist = JSON.parse(localreview);
		let modalItem = ``;
		if(reviewlist.length > 0){
			for(let r = 0; r < reviewlist.length; r++){
				modalItem += `
					<li>
						<strong>${reviewlist[r].name}</strong>
						${reviewlist[r].content}
					</li>
				`;
			}
		} else{
			
		}
		reviewArea.innerHTML = modalItem;
	}
}

function reviewRegist3() {
	let name = document.getElementById("nickname3").value;
	let content = document.getElementById("content3").value;

	if(!name || !content){
		alert("빈 칸이 없도록 입력해주세요.")
		return;
	} else{
		const review = {
			name: name,
			content: content,
		};
		
		let update;
		if(localStorage.getItem("review3") === null){
			update = JSON.stringify(review);
		} else{
			let pre = localStorage.getItem("review3");
			update = pre + JSON.stringify(review);
		}
		
		localStorage.setItem("review3", update);
		let localreview = localStorage.getItem("review3");
		localreview = "[" + localreview.replace(/}{/g, "},{") + "]";
		alert("리뷰 등록 완료");
		console.log(localreview);

		let reviewArea = document.querySelector(".review-list-3")
		let reviewlist = JSON.parse(localreview);
		let modalItem = ``;
		if(reviewlist.length > 0){
			for(let r = 0; r < reviewlist.length; r++){
				modalItem += `
					<li>
						<strong>${reviewlist[r].name}</strong>
						${reviewlist[r].content}
					</li>
				`;
			}
		} else{
			
		}
		reviewArea.innerHTML = modalItem;
	}
}

function reviewRegist4() {
	let name = document.getElementById("nickname4").value;
	let content = document.getElementById("content4").value;

	if(!name || !content){
		alert("빈 칸이 없도록 입력해주세요.")
		return;
	} else{
		const review = {
			name: name,
			content: content,
		};
		
		let update;
		if(localStorage.getItem("review4") === null){
			update = JSON.stringify(review);
		} else{
			let pre = localStorage.getItem("review4");
			update = pre + JSON.stringify(review);
		}
		
		localStorage.setItem("review4", update);
		let localreview = localStorage.getItem("review4");
		localreview = "[" + localreview.replace(/}{/g, "},{") + "]";
		alert("리뷰 등록 완료");
		console.log(localreview);

		let reviewArea = document.querySelector(".review-list-4")
		let reviewlist = JSON.parse(localreview);
		let modalItem = ``;
		if(reviewlist.length > 0){
			for(let r = 0; r < reviewlist.length; r++){
				modalItem += `
					<li>
						<strong>${reviewlist[r].name}</strong>
						${reviewlist[r].content}
					</li>
				`;
			}
		} else{
			
		}
		reviewArea.innerHTML = modalItem;
	}
}

function reviewRegist5() {
	let name = document.getElementById("nickname5").value;
	let content = document.getElementById("content5").value;

	if(!name || !content){
		alert("빈 칸이 없도록 입력해주세요.")
		return;
	} else{
		const review = {
			name: name,
			content: content,
		};
		
		let update;
		if(localStorage.getItem("review5") === null){
			update = JSON.stringify(review);
		} else{
			let pre = localStorage.getItem("review5");
			update = pre + JSON.stringify(review);
		}
		
		localStorage.setItem("review5", update);
		let localreview = localStorage.getItem("review5");
		localreview = "[" + localreview.replace(/}{/g, "},{") + "]";
		alert("리뷰 등록 완료");
		console.log(localreview);

		let reviewArea = document.querySelector(".review-list-5")
		let reviewlist = JSON.parse(localreview);
		let modalItem = ``;
		if(reviewlist.length > 0){
			for(let r = 0; r < reviewlist.length; r++){
				modalItem += `
					<li>
						<strong>${reviewlist[r].name}</strong>
						${reviewlist[r].content}
					</li>
				`;
			}
		} else{
			
		}
		reviewArea.innerHTML = modalItem;
	}
}

function reviewRegist6() {
	let name = document.getElementById("nickname6").value;
	let content = document.getElementById("content6").value;

	if(!name || !content){
		alert("빈 칸이 없도록 입력해주세요.")
		return;
	} else{
		const review = {
			name: name,
			content: content,
		};
		
		let update;
		if(localStorage.getItem("review6") === null){
			update = JSON.stringify(review);
		} else{
			let pre = localStorage.getItem("review6");
			update = pre + JSON.stringify(review);
		}
		
		localStorage.setItem("review6", update);
		let localreview = localStorage.getItem("review6");
		localreview = "[" + localreview.replace(/}{/g, "},{") + "]";
		alert("리뷰 등록 완료");
		console.log(localreview);

		let reviewArea = document.querySelector(".review-list-6")
		let reviewlist = JSON.parse(localreview);
		let modalItem = ``;
		if(reviewlist.length > 0){
			for(let r = 0; r < reviewlist.length; r++){
				modalItem += `
					<li>
						<strong>${reviewlist[r].name}</strong>
						${reviewlist[r].content}
					</li>
				`;
			}
		} else{
			
		}
		reviewArea.innerHTML = modalItem;
	}
}

function reviewRegist7() {
	let name = document.getElementById("nickname7").value;
	let content = document.getElementById("content7").value;

	if(!name || !content){
		alert("빈 칸이 없도록 입력해주세요.")
		return;
	} else{
		const review = {
			name: name,
			content: content,
		};
		
		let update;
		if(localStorage.getItem("review7") === null){
			update = JSON.stringify(review);
		} else{
			let pre = localStorage.getItem("review7");
			update = pre + JSON.stringify(review);
		}
		
		localStorage.setItem("review7", update);
		let localreview = localStorage.getItem("review7");
		localreview = "[" + localreview.replace(/}{/g, "},{") + "]";
		alert("리뷰 등록 완료");
		console.log(localreview);

		let reviewArea = document.querySelector(".review-list-7")
		let reviewlist = JSON.parse(localreview);
		let modalItem = ``;
		if(reviewlist.length > 0){
			for(let r = 0; r < reviewlist.length; r++){
				modalItem += `
					<li>
						<strong>${reviewlist[r].name}</strong>
						${reviewlist[r].content}
					</li>
				`;
			}
		} else{
			
		}
		reviewArea.innerHTML = modalItem;
	}
}
```

<br>
<br>

### ✔️ 구현 결과

### ➕ `메인 화면`

![main.png](PJT02%201a524e33488041aa8fc15a14c0fce0b7/main.png)
<br>

### ➕ `인기영상 TOP3 화면`

![top3.png](PJT02%201a524e33488041aa8fc15a14c0fce0b7/top3.png)
<br>

### ➕ `전체 영상 보기 화면`

![videolist.png](PJT02%201a524e33488041aa8fc15a14c0fce0b7/videolist.png)
<br>

### ➕ `영상 클릭 시 화면`

![video-detail-01noReview.png](PJT02%201a524e33488041aa8fc15a14c0fce0b7/video-detail-01noReview.png)
<br>

### ➕ `리뷰 등록 클릭 시 화면`

![video-detail-02reviewRegister.png](PJT02%201a524e33488041aa8fc15a14c0fce0b7/video-detail-02reviewRegister.png)
<br>

### ➕ `닉네임과 내용 입력 화면`

![video-detail-03reviewRegister.png](PJT02%201a524e33488041aa8fc15a14c0fce0b7/video-detail-03reviewRegister.png)
<br>

### ➕ `리뷰 저장 시 화면`

![video-detail-04reviewRegister.png](PJT02%201a524e33488041aa8fc15a14c0fce0b7/video-detail-04reviewRegister.png)
<br>

![video-detail-05reviewRegister.png](PJT02%201a524e33488041aa8fc15a14c0fce0b7/video-detail-05reviewRegister.png)
<br>

### ➕ `리뷰 목록 화면`

![video-detail-06Reviewlist.png](PJT02%201a524e33488041aa8fc15a14c0fce0b7/video-detail-06Reviewlist.png)
<br>

### ➕ `로그인 화면`

![login-01.png](PJT02%201a524e33488041aa8fc15a14c0fce0b7/login-01.png)
<br>

![login-02.png](PJT02%201a524e33488041aa8fc15a14c0fce0b7/login-02.png)
<br>

![login-03.png](PJT02%201a524e33488041aa8fc15a14c0fce0b7/login-03.png)
<br>

### ➕ `회원가입 화면`

![joinin-01.png](PJT02%201a524e33488041aa8fc15a14c0fce0b7/joinin-01.png)
<br>

![joinin-02.png](PJT02%201a524e33488041aa8fc15a14c0fce0b7/joinin-02.png)
<br>

![joinin-03.png](PJT02%201a524e33488041aa8fc15a14c0fce0b7/joinin-03.png)
<br>

![joinin-04.png](PJT02%201a524e33488041aa8fc15a14c0fce0b7/joinin-04.png)
<br>

### ➕ `소개화면`

![team.png](PJT02%201a524e33488041aa8fc15a14c0fce0b7/team.png)
<br>

### ➕ `전체화면`

![전체화면캡쳐.jpeg](PJT02%201a524e33488041aa8fc15a14c0fce0b7/%25EC%25A0%2584%25EC%25B2%25B4%25ED%2599%2594%25EB%25A9%25B4%25EC%25BA%25A1%25EC%25B3%2590.jpeg)

<br>
<br>

### ✔️ 이번 PJT를 통해 배운 내용

- 이번 프로젝트를 진행하는 내내 web front야말로 기초부터 탄탄하게 잘 쌓아가는게 필요하다고 느껴졌다. 어느 부분에서 오류가 왜 나는건지 빠르게 파악이 안되었고… 어느 부분을 어떻게 고쳐야할지 이것저것 해보면서 시간이 많이 걸리게 된 것 같다..
- 팀원인 채은이와 각자 가지고 있는 강점이 잘 활용되어 프로젝트가 완성이 되는 것을 경험해보며 맡은 일에 충실하게 하면서도 지속적으로 소통하며 문제를 해결해나가는 것도 중요하다는 것을 배우게 되었다!
- Object → JSON은 JSON.stringify /  JSON → Object는 JSON.parse 사용!

<br>
<br>

### ✔️ 후기

- 작업하는 부분이 눈에 바로바로 보여서 재밌었고 성취감이 느껴졌다.! 분업이 잘 되어 재밌었다!!
- 맡은 부분을 진행하다가 오류가 해결되지 않을 때 채은이가 적극적으로 도와주고 틀린 부분을 바로잡아준 덕분에 오래 걸리지 않고 잘 해결해 나갈 수 있었다. ㅜ_ㅜ
- 어려운 부분은 열심히 꼼꼼하게 공부해보고, 직접 구현해보면서 꾸준하게 학습하는 것이 필요하다고 느꼈다.