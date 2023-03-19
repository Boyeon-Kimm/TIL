<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Video Info</title>
<style>
  .videoinfo{
    display: flex;
    padding-top: 10%;
    flex-direction: column;
    justify-content: center;
    align-items: center;
	/* min-height: 100vh; */
    
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
  .reviews{
    display: flex;
    flex-direction: row;
    padding: 10px;
  }
  .reviewctrl{
    margin: 0px 5px !important;
  }
  .reviewcontainer{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width : 100%;
  }
  table{
    margin:20px;
    width:70%;
  }
  ul.review-list {
    width: 100%;
  }
  #newreview{
    margin:10px;
  }
  .writer{
    width: 30%;
  }
.content{
  width: 50%;
}
.updatebtn{
  width: 10%;
}
.deletebtn{
  width: 10%;
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
  <div class="videoinfo">
    <h3 class="text-uppercase">${video.title }</h3>
    <div class="item-intro">영상 조회 수 : ${video.viewCnt}</div>
    <p class="item-intro text-muted">${video.channelName }</p>
    <div class="videoplayer">
      <iframe src="https://www.youtube.com/embed/${video.youtubeId }"></iframe>
    </div>
    <p></p>
  </div>
  <div class="reviewcontainer">    
      <h5>영상 리뷰</h5>      
      <c:choose>
        <c:when test="${reviewlist eq null}">
          <strong>등록된 리뷰가 없습니다</strong>
        </c:when>
        <c:otherwise>
          <table>
            <thead> 
              <tr>
                <th>작성자</th>
                <th>내용</th>              
              </tr>
            </thead>
            <tbody>

              <c:forEach var="review" items="${reviewlist }">
                <tr>
                  <td class="writer" style="">${review.writer }</td>
                <td class="content">${review.content }</td>
                <td class="updatebtn">
                  <form action="main" method="POST">
                    <input type="hidden" name="act" value="updateform">
                    <input type="hidden" name="videoId" value="${video.youtubeId }">
                    <input type="hidden" name="reviewIdx" value="${review.idx }">
                    <button class="btn btn-dark reviewctrl">수정</button>
                  </form>
                </td>
                <td class="deletebtn"> 
                  <form action="main" method="POST">
                    <input type="hidden" name="act" value="delete">
                    <input type="hidden" name="videoId" value="${video.youtubeId }">
                    <input type="hidden" name="reviewIdx" value="${review.idx }">
                    <button class="btn btn-dark reviewctrl">삭제</button>
                    </form>
                  </td>
                </tr>  
              </c:forEach>           
            </tbody>
          </table>
        </c:otherwise>
      </c:choose> 
    <a id="newreview" class="btn btn-primary btn-xl text-uppercase" type="button" href="main?act=writeform&videoId=${video.youtubeId }">리뷰 등록</a>    
  </div>
</body>
</html>