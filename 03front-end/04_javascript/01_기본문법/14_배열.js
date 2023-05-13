let arr = [];
let arr2 = new Array();

arr[0] = 10;
// arr[2] = 30;
// console.log(arr[0], arr[1], arr[2], arr[3]);

// arr[3] = "문자열";
// arr[4] = {};
// arr[5] = [1, 2, 3];
// arr[6] = true;
// arr["msg"] = "가즈아 피자먹으러...";
// console.log(arr);

arr.push("추가"); // 배열의 가장 마지막에 추가
console.log(arr);
arr.pop(); // 배열의 가장 마지막 제거
console.log(arr);
arr.unshift("추가"); // 배열의 맨 앞에 추가
console.log(arr);
arr.shift(); // 배열의 맨 앞 제거
console.log(arr);
arr.includes(); // 특정 값 있는지 판별
console.log(arr.includes(10));
arr.indexOf(); // 특정 값의 인덱스 반환, 없으면 -1
console.log(arr.indexOf(10));
arr.push(20);
arr.unshift(0);
console.log(arr.join()); // 구분자로 연결하여 반환, 생략시 쉼표 기본

for (index in arr) {
  console.log(`${index} : ${arr[index]}`);
  // console.log(`index : arr[index]`);
}

//그냥 index : arr[index] 라고 쓰면
//안되나요?
