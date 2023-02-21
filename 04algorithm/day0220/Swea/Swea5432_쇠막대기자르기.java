package Homework;

import java.util.Scanner;
import java.util.Stack;

public class Swea5432_쇠막대기자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		// t번의 테스트 케이스
		for(int tc = 1; tc <= t; tc++) {
			// 문자열로 받아서 char배열에 넣기
			String str = sc.next();
			char[] arr = str.toCharArray();
			Stack<Character> stack = new Stack<>();
			// 잘려진 조각의 총 개수
			int pieces = 0;
			// 괄호의 개수만큼 반복
			for(int i = 0; i < arr.length; i++) {
				// '(' 스택에 입력
				if(arr[i] == '(') {
					stack.push(arr[i]);
				// ')' 괄호 직전 배열에 '('가 있다면 레이저
				// '(' 을 pop해서 레이저 제거
				// 레이저로 잘릴 경우 기존에 있던 막대기 개수만큼 증가함
				// 기존에 있던 막대기 == 스택에 쌓여있는 '(' 개수들
				} else if(arr[i] == ')' && arr[i - 1] == '(') {
					stack.pop();
					pieces += stack.size();
				// ')' 직전 배열에 ')'가 있다면 크기를 1만큼 증가시킴
				} else if(arr[i] == ')' && arr[i - 1] == ')') {
					stack.pop();
					pieces += 1;
				}
			}
			System.out.printf("#%d %d\n", tc, pieces);
		}
	}
}
