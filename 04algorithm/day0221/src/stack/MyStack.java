package stack;

public class MyStack implements Stack{
	// Array를 활용해서 구현해봅시다 

	public static void main(String[] args) {
		// 오랜만이야 생성자 :) 
		MyStack myStack = new MyStack(5);
		
		
	}
	
	static int top; // 스택의 포인터
	static int N; // 스택의 크기
	static int stack[]; // 스택
	
	// 생성자를 활용해서 스택 생성
	public MyStack (int stackSize) {
		top = -1; // 스택 포인터 초기화
		N = stackSize;
		stack = new int[N]; // 스택 생성
	}
	
	
	public boolean isEmpty() {
		// hint: 스택 포인터가 -1이면.. 데이터가 없는 경우 일 것.
		// 조건 1: isEmtpy -> true
		
		// 조건 2: not empty -> false
	}

	
	public boolean isFull() {
		// hint: 스택 포인터 == 전체크기 -1이면.. 꽉 차 있는 것
		// 조건 1: isFull -> true
		
		// 조건 2: not full -> false
		
	}

	
	public void push(int value) {
		// 조건 1: isFull하면, 더이상 넣을 수 없다.
		
		// 조건 2: 빈 공간이 있다면, 값을 추가할 수 있다.
		
	}

	
	public void pop() {
		// 조건 1: isEmpty하면 뽑아낼 것들이 없다.
		
		// 조건 2: 하나라도 있으면 뽑아낼 수 있다.
	}

	
	public void peek() {
		// 조건 1: isEmpty하면 보여줄 것들이 없다.
		
		// 조건 2: 하나라도 값이 있으면 보여줄 수 있다.
		
	}

	
	public void clear() {
		// 조건 1: isEmpty -> 지울게 없다.
		
		// 조건 2: 초기화한다. (반복문쓰지 말것)
		
	}

	
	public void printStack() {
		
	}
	
}
