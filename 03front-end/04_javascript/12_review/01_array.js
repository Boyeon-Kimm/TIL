var arr = [1, 2, 3, 4];

// for(let i=0; i<arr.length;i)

// foreach: 값마다 문장을 실행하고 싶을
arr.forEach((v, i, arr)=>{
    console.log(v, i, arr);
})

// mapping해서 새로운 배열
// 함수의 반환값이 새로운 배열의 원소
var arr2 = arr.map((v) => 3 * v);
console.log(arr2);

// filter해서 새로운 배열
// 함수가 true, false
var arr3 = arr.filter((v) => v % 2 === 0);
console.log(arr3);

// 하나의 원소 찾기
// true가 나오면
var num = arr.find((v) => v % 2 === 0);
console.log(num);

console.log(arr.pop());
console.log(arr);

arr.unshift(5);
console.log(arr);
