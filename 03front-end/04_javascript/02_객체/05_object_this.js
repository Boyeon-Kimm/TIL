// 함수 안에서 this는 함수를 호출한 객체이다.
// 메서드 안에서 this는 해당 메서드를 멤버로 가지고 있는 객체이다.

let m1 = { name: "홍길동" };
let m2 = { name: "배수지" };

function msg() {
  console.log(this);
  console.log(this.name + "님이 입장합니다.");
}

m1.a = msg;
m2.a = msg;
m1.a();
m2.a();
