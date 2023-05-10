function foo() {
  console.log("foo");
}

// delay 시간 동안 멈춤, 대기(동기)
function sleep(delay) {
  var start = new Date().getTime();
  while (new Date().getTime() < start + delay);
}

function bar() {
  console.log("bar");
}

sleep(3000);
foo();
sleep(3000);
bar();
