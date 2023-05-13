let obj = {
  b: function () {
    console.log("function b");
  },
};
let obj2 = new Object();
obj2.b = function () {
  console.log("function b");
};
function Member() {}
// 일반함수 -> 그냥 쓰면 일반함수
//         -> new를 붙여서 쓰면 생성자함수
let member = new Member();
member["b"] = function () {
  console.log("function b");
};
// console.log(obj);
// console.log(obj2);
// console.log(member);

obj.b();
obj2.b();
member.b();

Object.prototype.a = function () {
  console.log("prototype a");
};

obj.a();
obj2.a();
member.a();

Member.prototype.c = function () {
  console.log("prototype c");
};

// obj.c();
// obj2.c();
member.c();

let member2 = new Member();
member2.c();
