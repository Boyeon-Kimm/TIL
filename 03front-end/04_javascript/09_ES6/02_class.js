class Shape {
  constructor(id, x, y) {
    this.id = id;
    this.move(x, y);
  }
  move(x, y) {
    this.x = x;
    this.y = y;
  }
}

let shape = new Shape(1, 100, 100);
console.log(typeof Shape);
console.log(shape);
shape.move(150, 150);
console.log(shape);
console.log(typeof shape);
console.log(shape instanceof Shape);

console.log("----------------");
var Shape2 = function (id, x, y) {
  this.id = id;
  this.move(x, y);
};
Shape2.prototype.move = function (x, y) {
  this.x = x;
  this.y = y;
};

let shape2 = new Shape2(1, 200, 200);
console.log(typeof Shape2);
console.log(shape2);
shape2.move(250, 250);
console.log(shape2);
console.log(typeof shape2);
console.log(shape2 instanceof Shape2);

function Shape3 (id, x, y) {
  this.id = id;
  this.move = function (x, y) {
    this.x = x;
    this.y = y;
  }
  this.move(x, y);
};

let shape3 = new Shape3(3, 300, 300);
console.log(shape3);
