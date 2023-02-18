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