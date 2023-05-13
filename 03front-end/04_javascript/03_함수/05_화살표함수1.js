function func() {
  console.log("선언식 함수");
}

// 화살표 함수를 만드는 단계
// 1. function 키워드 제거
// 2. () 파라미터 작성
//    - 매개변수가 하나만 있으면 ()생략
// 3. => 화살표 작성
// 4. {} 함수 내용 작성
//    - 문장이 하나만 있으면 {} 생략
//    - 문장이 하나일 때 return문도 생략 가능.

let arrFunc = () => {
  console.log("화살표 함수");
};

arrFunc();
