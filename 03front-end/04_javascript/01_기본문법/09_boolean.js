console.log(!!0);
console.log(!!""); // 빈문자열
console.log(!!null);
console.log(!!undefined);
console.log(!!NaN);
console.log(!!"0"); // 빈문자열이 아닌 것.
console.log(!!"abc"); // 빈문자열이 아닌 것.
console.log(!!Number("0"));
console.log(Boolean());

// 선언만 하고 값을 할당하지 않으면 기본적으로 undefined
let id;
console.log(id);
if (id) {
  console.log("id 값이 있는 경우.");
} else {
  console.log("id 값이 없는 경우");
}
