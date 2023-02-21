package Homework;

import java.util.Scanner;
import java.util.Stack;
public class Swea_계산기1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			// 문자열 계산식의 길이
			int len = sc.nextInt();
			// 문자열 입력받은 후 char배열에 넣기
			String str = sc.next();
			char[] arr = str.toCharArray();
			// 후위표기법을 넣을 배열 생성
			char[] num = new char[arr.length - 1];
			// 연산자를 넣을 스택 생성
			Stack<Character> stack = new Stack<>();
			int j = 0;
			// 중위표기법 -> 후위표기법
			// + 기호가 아니라면 배열에 숫자 입력
			// + 기호라면 1. 스택에 이미 +가 있다면 배열에 +넣기
			// 2. 스택에 +가 없다면 스택에 추가
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] != '+') {
					num[j] = arr[i];
					j++;
				} else {
					if(!stack.isEmpty()) {
						num[j] = arr[i];
						j++;
					}
					else stack.push(arr[i]);
				}
			}
			// 총 합을 구할 스택 생성
			Stack<Integer> sumStack = new Stack<>();
			// 후위표기식이 들어있는 char배열 처음부터 끝까지 반복문을 돌며
			// 피연산자일 경우
			// 1. 스택에 숫자가 있다면 그 값을 꺼내 배열의 숫자와 더해준다
			// 2. 더해준 값을 다시 스택에 넣는다.
			// 스택에 숫자가 없다면 그 값을 스택에 넣는다.
			for(int i = 0; i < num.length; i++) {
				if(num[i] != '+') {
					if(!sumStack.isEmpty()) {
						sumStack.push(num[i] - '0' + sumStack.pop());
					} else sumStack.push(num[i] - '0');
				} else continue;
			}
			// 스택에 있는 값에 누적으로 더해주었기 때문에 들어있는 숫자는 1개
			// 해당 숫자를 꺼내서 출력
			System.out.printf("#%d %d\n", tc, sumStack.pop());
 		}
	}
}
