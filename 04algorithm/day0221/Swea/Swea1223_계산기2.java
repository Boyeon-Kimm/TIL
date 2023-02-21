package Homework;

import java.util.Scanner;
import java.util.Stack;

public class Swea1223_계산기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 10번의 테스트 케이스
		for(int tc = 1; tc <= 10; tc++) {
			// 테스트 케이스의 길이
			int len = sc.nextInt();
			String str = sc.next();
			char[] arr = str.toCharArray();
			// 연산자를 담을 스택
			Stack<Character> stack = new Stack<>();
			// 숫자 계산할 스택
			Stack<Integer> calStack = new Stack<>();
			// 후위표기식 담을 배열
			char[] nums = new char[arr.length];
			int j = 0;
			
			for(int i = 0; i < arr.length; i++) {
				// 피연산자라면 후위표기식 배열에 바로 넣는다
				if(arr[i] != '+' && arr[i] != '*') {
					nums[j] = arr[i];
					j++;
				// 연산자라면
				// 1. 스택이 비었다면 어떤 기호든 push
				// 2. 스택에 무엇인가 있다면 +인지 *인지 확인한다
				// 2-1. 아스키코드 상 * == 42, + == 43 라서 대소비교로 진행
				// 2-2. 만약 스택에 *가 있는데 배열에 +가 있다면, 스택에 있던 *를 배열에 옮긴 후 +를 배열에 담는다.
				// 2-3. 스택에 +가 있는데 배열에 *가 있다면 스택에 * 추가
				// 2-4. 기호가 같을 땐 기호를 배열에 넣는다.
				} else {
					if(stack.isEmpty()) stack.push(arr[i]);
					else {
						if(arr[i] > stack.peek()) {
							nums[j] = stack.pop();
							++j;
							nums[j] = arr[i];
							j++;
						} else if (arr[i] < stack.peek()) {
							stack.push(arr[i]);
						} else {
							nums[j] = arr[i];
							j++;
						}
					}
				}
			}
			// stack이 빌때까지 nums의 배열에 옮겨준다.
			// stack의 후입선출 성격을 고려해 nums의 인덱스를 배열의 길이 - 스택의 길이 + i 부터 채워지도록 함.
			// ex) 5 - 2 + 0 = 3 배열의 인덱스 3부터 채워지게끔..
			while(!stack.isEmpty()) {
				for(int i = 0; i < stack.size(); i++) {
					nums[nums.length - stack.size() + i] = stack.pop();
				}
			}
			// 새로운 스택에 숫자라면 바로 넣고
			// 연산자라면 있던 숫자 꺼내서 계산 수행
			// 스택에 숫자가 2개 이상일 때만 2개 pop 하여 계산하도록 함
			for(int i = 0; i < nums.length; i++) {
				if(nums[i] != '+' && nums[i] != '*') calStack.push(nums[i] - '0');
				else {
					if(nums[i] == '*')
						calStack.push(calStack.pop() * calStack.pop());
					else {
						if(calStack.size() > 1)
							calStack.push(calStack.pop() + calStack.pop());
					}
				}
			}
			// 스택이 빌 때까지 숫자 빼서 계산
			int calculate = 0;
			if(!calStack.isEmpty()) {
				for(int i = 0; i < calStack.size(); i++) {
					calculate += calStack.get(i);
				}
			}
			System.out.printf("#%d %d\n", tc, calculate);
		}
		sc.close();
	}
}
