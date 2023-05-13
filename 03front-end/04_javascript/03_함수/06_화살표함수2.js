// 매개변수가 하나 있는 경우
let a = num => {
  console.log(num);
};

let b = (num) => {
  console.log(num);
};

a(10);
b(11);

// 매개변수가 여러개인 경우
let c = (num1, num2) => {
  console.log(num1, num2);
};

c(10, 20);
