var params = ["hello", true, 7];
var other = [1, 2, ...params]; // [ 1, 2, "hello", true, 7 ]
// console.log(other);

// function foo(...args) {
//   console.log(args);
// }
// foo(1, 2, 3, 4, 5);

// function bar(first, ...rest) {
//   console.log(first);
//   console.log(rest);
// }
// bar(1, 2, 3, 4, 5);

// function f(x, y, ...a) {
//   return (x + y) * a.length;
// }
// console.log(f(1, 2, ...params));
// console.log(f(1, 2, ...other));

// var str = "foo";
// var chars = [...str]; // [ "f", "o", "o" ]
// console.log(chars);

// spread 연산자가 유용하게 쓰이는 곳!
// : 깊은 복사를 할 때

// 얕은 복사: 주소값을 복사 => 어느 하나를 고치면, 나머지도 똑같이 고쳐져요.
// 깊은 복사: 아예 새로운 객체, 배열을 만드는 것이고, 다른 주소값을 갖게됨, 어느 하나를 고쳐도, 다른 하나에는 영향이 없음

// var arr = [1, 2, 3, 4];
// var arr2 = [...arr];
// arr.shift();
// console.log(arr);
// console.log(arr2);

var obj = {
  name: "haha",
  age: 33,
};
var obj2 = { ...obj };
obj.name = "hoho";
console.log(obj);
console.log(obj2);
