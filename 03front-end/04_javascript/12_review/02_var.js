var a = "global a";

function f() {
  console.log(a); // ?

  var a = "function a";

  console.log(a); // ?
}

f();
