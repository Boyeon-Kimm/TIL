package test01;

import java.util.Stack;

public class Test2 {
	public static void main(String[] args) {
		// Stack은 클래스로 구현이 되어있음
		Stack<Integer> stack = new Stack<>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
